package com.wat.springbootv;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;

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
	// Location loc = new Location();
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
		getServerIP();
		model.addAttribute("ipServer", serverIP);
		// if(loc.getLatitude()==null||loc.getLongitude()==null){
		// model.addAttribute("latitude", "Brak aktualnego po³o¿enia");
		// model.addAttribute("longitude", "Brak aktualnego po³o¿enia");
		// }else{
		// model.addAttribute("latitude", loc.getLatitude().toString());
		// model.addAttribute("longitude", loc.getLongitude().toString());
		// getServerIP();
		// model.addAttribute("ipServer", serverIP);
		// }
		return "hello";
	}

	@RequestMapping(value = "/socket", method = RequestMethod.GET)
	public String socket() {
		return "socket";
	}

	public void getServerIP() {
		InetAddress ip = null;
		String hostname;

		try {
			for (NetworkInterface networkInterface : Collections
					.list(NetworkInterface.getNetworkInterfaces())) {
				if (networkInterface.isVirtual() == false) {
					//Dziala dla mojego(na tym laptopie) polaczenia WIFI
					if (networkInterface.getDisplayName().equals(
							"Dell Wireless 1703 802.11b/g/n (2.4GHz)")) {
						ip = networkInterface.getInterfaceAddresses().get(0)
								.getAddress();
					} 
				}
			}
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

			serverIP = ip.getHostAddress();
			
			//Podstawowe pobranie adresu nie dziala bo krzaczy sie jezeli sa wirtualne hosty(np przy 
			//vmware czy virtualBox)
			
			// ip = InetAddress.getLocalHost();
			// serverIP = ip.getHostAddress();
	}
}
