package com.wat.springbootv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationListenerController {

//	Location loc =new Location();
	private LocationStorage locationStorage;

	@Autowired
	public LocationListenerController(LocationStorage locationStorage) {
		super();
		this.locationStorage = locationStorage;
	}

	private Logger log = LoggerFactory.getLogger(getClass());

	@MessageMapping("/locationListener")
 
	@RequestMapping(value = "/locationListener", method = RequestMethod.POST)
	public ResponseEntity<String> locationListener(@RequestBody Location location){

		Location loc = new Location();
		loc.setLatitude(location.getLatitude());
		loc.setLongitude(location.getLongitude());
		loc.setgForce(location.getgForce());
		log.info("Lokalizacja : " + location.getLatitude()+ " " + location.getLongitude()+ " Sila grawitacyjna: " + location.getgForce());
		locationStorage.setLocation(loc);
		return new ResponseEntity<String>(HttpStatus.OK);	
	}

}

