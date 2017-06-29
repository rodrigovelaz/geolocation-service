package org.rodrigovelaz.geolocationservice.business.service;

import java.io.IOException;

import org.rodrigovelaz.geolocationservice.presentation.json.GeolocationJson;

public interface GeolocationService {

	public GeolocationJson getGeoLocationDto(String ip) throws IOException;
	
}
