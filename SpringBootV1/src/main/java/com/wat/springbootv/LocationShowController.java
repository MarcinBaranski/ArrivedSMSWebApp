package com.wat.springbootv;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

	String serverIP;
	Location loc = new Location();

	@Autowired
	public LocationShowController(LocationStorage locationStorage) {
		super();
		loc=locationStorage.getLocationSt();
	}

	@ModelAttribute("loc")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greeting(Model model) {
		if(loc.getLatitude()==null||loc.getLongitude()==null){
			model.addAttribute("latitude", "Brak aktualnego po�o�enia");
			model.addAttribute("longitude", "Brak aktualnego po�o�enia");
		}else{
			model.addAttribute("latitude", loc.getLatitude().toString());
			model.addAttribute("longitude", loc.getLongitude().toString());
			getServerIP();
			model.addAttribute("ipServer", serverIP);
		}
		return "hello";
	}
	
	public void getServerIP(){
		InetAddress ip;
		String hostname;
		try {
			ip = InetAddress.getLocalHost();
			serverIP = ip.getHostAddress();
			//			hostname = ip.getHostName();
			//			System.out.println("Your current IP address : " + ip);
			//			System.out.println("Your current Hostname : " + hostname);

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
	}
}