package com.wat.springbootv;



public class Location {

	

	private String longitude;
	private String latitude;
	private String ipServer;
	private String gForce;
	private String login;
	
	public Location() {
		super();
	}

	public Location(String longitude, String latitude,String ipServer,String gForce) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.ipServer = ipServer;
		this.gForce = gForce;
		this.login = login;
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

	public String getgForce() {
		return gForce;
	}

	public void setgForce(String gForce) {
		this.gForce = gForce;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
