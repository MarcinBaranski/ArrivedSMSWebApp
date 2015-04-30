package com.wat.springbootv;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("com.wat")
@EnableAutoConfiguration
@Configuration
@EnableWebMvc


public class App extends WebMvcAutoConfiguration {

	
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    
        
    }
    

}