package com.wat.springbootv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.org.glassfish.gmbal.NameValue;





@Component
public class LocationStorage {
	
	
	 Location locationSt= new Location();


	public Location getLocationSt() {
		return locationSt;
	}

	public void setLocationSt(Location locationSt) {
		this.locationSt = locationSt;
	}

}
