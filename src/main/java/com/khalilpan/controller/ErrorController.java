package com.khalilpan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController("error")
//@Controller("error")
public class ErrorController {

	//it will handle all the exceptions
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request,HttpServletResponse response,Exception ex) {
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("Exception",ex.getStackTrace());
		mView.addObject("url",request.getRequestURL());
		mView.setViewName("error");
		
		return mView;
	}
	
}
