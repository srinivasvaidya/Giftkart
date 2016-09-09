package com.wells.giftkart.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wells.giftkart.service.IUserService;
import com.wells.giftkart.valueobject.User;

@Controller
public class LoginController {

	@Autowired
	IUserService userService;
	
	public static final Logger logger=Logger.getLogger(LoginController.class) ;
	
	@ExceptionHandler(IOException.class)
	public ModelAndView hanleIOException()
	{
		logger.info("hanleIOException() started ");
		//System.out.println("login page");
		ModelAndView errorview=new ModelAndView("error");
		return errorview;
	}
	@RequestMapping(value="/userlogin/time", method=RequestMethod.GET) 
	public @ResponseBody String login_ajax() 
	{
		logger.info("login_ajax() ajax started ");
		System.out.println("login_ajax page invoked");
		
		logger.info("login_ajax() end ");
		return "time is 10 PM";
	}
	
	@RequestMapping(value="/userlogin", method=RequestMethod.GET)
	public ModelAndView login()
	{
		logger.info("login() started ");
		System.out.println("login page");
		ModelAndView loginview=new ModelAndView("userlogin");
		logger.info("login() end ");
		return loginview;
	}
	
	@RequestMapping(value="/userlogin", method=RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute("userform") User userform,HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("authenticate() started ");
		//logger.debug("username: "+ userform.getUsername());
		logger.debug("userid: "+ userform.getUserId());
		logger.debug("user pwd: "+userform.getPassword());
		
		User user= userService.getUserDetails(userform.getUserId());
		
		logger.debug("user  FROM db: "+user);
		logger.debug("user pwd FROM db: "+user.getPassword());
		if(userform.getPassword().equalsIgnoreCase(user.getPassword()))
		{
		logger.info("authentication success ");
			//ModelAndView loginview=new ModelAndView("home");
			
				request.getSession().setAttribute("user", user);
				logger.info("forwarding to home page ");		
				//request.getRequestDispatcher("products").forward(request, response);
				try {
					response.sendRedirect("home");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			logger.info("authenticate() end ");	
			return null;
		}
		else{
			logger.info("login authentication failed ");
			ModelAndView loginview=new ModelAndView("userlogin");
			logger.info(" returning to login page ");
			return loginview;
		}
		
	}
}
