package com.lms.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.service.IUserService;
import com.lms.valueobject.User;


@Controller
public class AdminController {

	public static final Logger logger=Logger.getLogger(LoginController.class) ;
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/adminlogin",method=RequestMethod.GET)   
	public ModelAndView adminlogin()
	{
		
		ModelAndView model = new ModelAndView(); 
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("adminlogin"); 
		
		return model; 
	}
	
/*	@RequestMapping(value="/adminlogin",method=RequestMethod.POST) 
	public ModelAndView adminlogin_post(@ModelAttribute("userform") User userform,HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("adminlogin_post() started ");
		
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("adminhome");

		logger.debug("userid: "+ userform.getUsername());
		logger.debug("user pwd: "+userform.getPassword());
		
		User user= userService.getUserDetails(userform.getUserId());
		request.getSession().setAttribute("user", user);
		
		logger.info("adminlogin_post() end ");
		return model;
	}
*/	
	@RequestMapping(value="/adminhome",method=RequestMethod.GET)
	public String adminWelcome()
	{
		return "adminhome";
	}
	
	@RequestMapping(value="/adminerror",method=RequestMethod.GET)
	public String errorpage()
	{
		return "adminerror";
	}

}
