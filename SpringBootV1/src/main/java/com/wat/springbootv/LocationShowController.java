package com.wat.springbootv;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@EnableWebMvc
@ComponentScan
public class LocationShowController {

	String serverIP;
//	Location loc = new Location();
	private LocationStorage locationStorage;

	@Autowired
	public LocationShowController(LocationStorage locationStorage) {
		super();
		this.locationStorage = locationStorage;
	}

	@ModelAttribute("loc")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greeting(Model model) {
		
		Location loc = locationStorage.getLocation();
//		if(loc.getLatitude()==null||loc.getLongitude()==null){
//			model.addAttribute("latitude", "Brak aktualnego po³o¿enia");
//			model.addAttribute("longitude", "Brak aktualnego po³o¿enia");
//		}else{
//			model.addAttribute("latitude", loc.getLatitude().toString());
//			model.addAttribute("longitude", loc.getLongitude().toString());
//			getServerIP();
//			model.addAttribute("ipServer", serverIP);
//		}
		return "hello";
	}
	
	@RequestMapping(value = "/socket", method = RequestMethod.GET)
	public String socket() {
		return "socket";
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
