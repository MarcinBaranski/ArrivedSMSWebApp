package com.wat.springbootv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class LocationUpdateListener {
	
	private SimpMessagingTemplate template;
	
	@Autowired
	public LocationUpdateListener(SimpMessagingTemplate template) {
		super();
		this.template = template;
	}

	public Location onLocationUpdate(Location location){
		System.out.println("listener got new location: " + location);
		String url = "/topic/updates";
		template.convertAndSend(url ,location);
		return location;
	}
}
