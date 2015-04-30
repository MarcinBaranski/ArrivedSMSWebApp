package com.wat.springbootv;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

	@RequestMapping("/login")
	public ResponseEntity<String> login(@RequestParam String login, @RequestParam String pwd){
		System.out.println("Login attempt" + login + " " + pwd);
		if(login.equals("Jacek")){
			System.out.println("Status ok");
			return new ResponseEntity<String>("temp", HttpStatus.OK);
		}else{
			System.out.println("No content");
			return new ResponseEntity<String>("temp", HttpStatus.NO_CONTENT);
		}
		
	}
}
