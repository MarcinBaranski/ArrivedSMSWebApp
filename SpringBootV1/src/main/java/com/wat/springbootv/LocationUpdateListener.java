package com.wat.springbootv;

import org.springframework.stereotype.Component;

@Component
public class LocationUpdateListener {
	public void onLocationUpdate(Location location){
		System.out.println("listener got new location: " + location);
	}
}
