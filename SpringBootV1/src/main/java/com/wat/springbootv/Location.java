package com.wat.springbootv;

import org.springframework.stereotype.Component;


public class Location {

	private String longitude;
	private String latitude;
	
	
	public Location() {
		super();
	}

	public Location(String longitude, String latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
}
