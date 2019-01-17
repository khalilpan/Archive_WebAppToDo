package com.khalilpan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	//http://localhost:8080/login
	@GetMapping("/login")
	public String loginMethod() {
		
		return "welcome khalil";
	}
	
	
}
