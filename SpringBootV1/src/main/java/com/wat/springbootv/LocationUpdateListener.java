package com.wat.springbootv;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class LocationUpdateListener {
	
//	@Autowired
//	private SimpMessagingTemplate template;
	
//	@Autowired
//	public LocationUpdateListener(SimpMessagingTemplate template) {
//		super();
//		this.template = template;
//	}

	@RequestMapping("/locationUpdate")
	@SendTo("/topic/updates")
	public Location onLocationUpdate(Location location){
		System.out.println("listener got new location: " + location);
//		String url = "/topic/updates";
//		template.convertAndSend(url ,location);
		return location;
	}
}
