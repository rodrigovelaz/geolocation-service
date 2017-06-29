package org.rodrigovelaz.geolocationservice.presentation.json;

public class GeolocationJson {
	
	private String ipAddress;
	private String continentCode;
	private String continentName;
	private String countryName;
	private String countryCode;

	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getContinentCode() {
		return continentCode;
	}
	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}
	public String getContinentName() {
		return continentName;
	}
	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		return "GeoLocationDto [continentCode=" + continentCode + ", continentName=" + continentName + ", countryName="
				+ countryName + ", countryCode=" + countryCode + "]";
	}
	
}
