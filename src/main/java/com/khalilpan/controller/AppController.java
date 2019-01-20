package com.khalilpan.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
//@SessionAttributes("userNameReceivedFromForm")//"userNameReceivedFromForm" is the name of ModelMap attribute
//"userNameReceivedFromForm" will be accessible in all the controllers that they put "@SessionAttributes" annotation in it
public class AppController {


	//"model" is used to pass som data from controller to jsp

	//@requestMapping(value="/login",method=RequestMethod.GET)//it will map all the requests(GET,POST,PUT,DELETE) to this method
	//by adding "method=RequestMethod.GET" we will control the just GET method
	
	//http://localhost:8080/
	@GetMapping("/")
	public ModelAndView showWelcomePage(ModelMap modelMap) {
		modelMap.put("userNameReceivedFromForm", getLoggedStringInUserName());
		return new ModelAndView("welcome");
	}
	
	
	//to get the "username" that is entered in "login" page from spring security 
	private String getLoggedStringInUserName() {
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		
		return principal.toString();
	}
	
	//http://localhost:8080/login
//		@PostMapping("/login")
//		public ModelAndView showWelcomePage(ModelMap modelMap,@RequestParam String enteredUserNameInForm,@RequestParam String enteredPasswordInForm) {
//			
//			boolean isValidOrNot=service.validateUserNamePassword(enteredUserNameInForm,enteredPasswordInForm);
//			
//			if(isValidOrNot==false) {
//				modelMap.put("errorMessage","Invalid UserName/Password");
//				return new ModelAndView("login");//if username and password didn´t match it will return login page
//			}
//			
//			//what ever we are adding in modelMap is availabe in JSP
//			modelMap.put("userNameReceivedFromForm",enteredUserNameInForm);
//			modelMap.put("passwordReceivedFromForm",enteredPasswordInForm);
//			
//			System.out.println("POST method called");
//			return new ModelAndView("welcome");
//		}
	
	
}
