package org.rodrigovelaz.geolocationservice.business.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.rodrigovelaz.geolocationservice.business.service.GeolocationService;
import org.rodrigovelaz.geolocationservice.presentation.json.GeolocationJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.maxmind.db.Reader;

@Service
public class GeolocationServiceImpl implements GeolocationService {

	private Reader reader;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostConstruct
	private void postConstruct() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("GeoLite2-Country.mmdb");		
		try {
			reader = new Reader(inputStream);
		} 
		catch (IOException e) {
			logger.error("Error creating Geo DB", e);
		}
	}
	
	@PreDestroy
	private void preDestroy() throws Exception {
		if (this.reader != null) this.reader.close();
	}
	
	@Override
	public GeolocationJson getGeoLocationDto(String ip) throws IOException {

		InetAddress address = InetAddress.getByName(ip);

		JsonNode response = this.reader.get(address);

		if (response == null) throw new RuntimeException("Couldn't get geolocation for ip: " + ip);

		JsonNode countryNode = response.get("country");
		if (countryNode == null) throw new RuntimeException("Couldn't get country node for ip: " + ip);
		
		JsonNode continentNode = response.get("continent");
		if (continentNode == null) throw new RuntimeException("Couldn't get continent node for ip: " + ip);

		GeolocationJson geoLocation = new GeolocationJson();
		geoLocation.setIpAddress(ip);
		geoLocation.setContinentCode(continentNode.get("code").asText());
		geoLocation.setContinentName(continentNode.get("names").get("en").asText());
		geoLocation.setCountryCode(countryNode.get("iso_code").asText());
		geoLocation.setCountryName(countryNode.get("names").get("en").asText());
		
		logger.debug("Ip [" + ip + "] -> " + geoLocation.toString());

		return geoLocation;
	}
	
}
