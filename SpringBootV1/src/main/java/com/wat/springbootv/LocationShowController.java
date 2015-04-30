package com.wat.springbootv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@EnableWebMvc
@ComponentScan
public class LocationShowController {

	Location loc = new Location();

	@Autowired
	public LocationShowController(LocationStorage locationStorage) {
		super();
		loc=locationStorage.getLocationSt();
	}

	@ModelAttribute("loc")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greeting(Model model) {
		model.addAttribute("latitude", loc.getLatitude().toString());
		model.addAttribute("longitude", loc.getLongitude().toString());
		return "hello";
	}
}
