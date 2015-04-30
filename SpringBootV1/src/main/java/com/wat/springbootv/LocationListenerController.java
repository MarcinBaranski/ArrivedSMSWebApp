package com.wat.springbootv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationListenerController {

	Location loc =new Location();

	@Autowired
	public LocationListenerController(LocationStorage locationStorage) {
		super();

		if(loc!=null){
			locationStorage.setLocationSt(loc);
		}
	}

	private Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/locationListener", method = RequestMethod.POST)
	public ResponseEntity<String> locationListener(@RequestBody Location location){

		log.info("Lokalizacja : " + location);
		loc.setLatitude(location.getLatitude());
		loc.setLongitude(location.getLongitude());

		return new ResponseEntity<String>(HttpStatus.OK);	
	}

}

