package com.wat.springbootv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationStorage {

	private LocationUpdateListener locationUpdateListener;
	private Location location = new Location();

	@Autowired
	public LocationStorage(LocationUpdateListener locationUpdateListener) {
		super();
		this.locationUpdateListener = locationUpdateListener;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
		locationUpdateListener.onLocationUpdate(location);
	}

}
