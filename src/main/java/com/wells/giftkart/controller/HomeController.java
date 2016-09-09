package com.wells.giftkart.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/home") 
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView getHomePage() 
	{
		logger.info(" getHomePage() started "); 
		ModelAndView welcomeview=new ModelAndView("home"); 
		
		logger.info(" getHomePage() end "); 
		return welcomeview;
	}
	
	}
