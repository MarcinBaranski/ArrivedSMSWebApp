package com.wat.springbootv;



public class Location {

	

	private String longitude;
	private String latitude;
	private String ipServer;
	
	public Location() {
		super();
	}

	public Location(String longitude, String latitude,String ipServer) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.ipServer = ipServer;
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

	public String getIpServer() {
		return ipServer;
	}

	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}
	
	
}
