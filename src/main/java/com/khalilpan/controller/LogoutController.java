package com.khalilpan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
//@SessionAttributes("userNameReceivedFromForm")//"userNameReceivedFromForm" is the name of ModelMap attribute
//"userNameReceivedFromForm" will be accessible in all the controllers that they put "@SessionAttributes" annotation in it
public class LogoutController {

	//to logout the user
	//http://localhost:8080/
	@GetMapping("/logout")
	public ModelAndView showWelcomePage(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication!=null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	
}
