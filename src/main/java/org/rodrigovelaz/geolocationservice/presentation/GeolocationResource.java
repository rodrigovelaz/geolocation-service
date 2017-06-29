package org.rodrigovelaz.geolocationservice.presentation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.rodrigovelaz.geolocationservice.business.service.GeolocationService;
import org.rodrigovelaz.geolocationservice.presentation.json.GeolocationJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geolocation")
public class GeolocationResource {

	private final static String X_FORWARDED_FOR = "X-Forwarded-For";
	
	@Autowired
	private GeolocationService geoLocationService;
	
	private String getIp(HttpServletRequest request) {
		
		String ipList = request.getHeader(X_FORWARDED_FOR);
		
		if (StringUtils.isEmpty(ipList)) return request.getRemoteAddr();

		if (!ipList.contains(",")){
			return ipList.trim();
		}
		else {
			String[] ips = ipList.split(",");
			return ips[0].trim();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public GeolocationJson getIpThenGetGeoLocation(HttpServletRequest request) throws IOException {
		String ip = this.getIp(request);
		return this.geoLocationService.getGeoLocationDto(ip);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{ip:.+}")
	public GeolocationJson getGeoLocation(@PathVariable String ip) throws IOException {
		return this.geoLocationService.getGeoLocationDto(ip);
	}

}