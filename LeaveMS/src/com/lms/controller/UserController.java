package com.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.service.IUserService;
import com.lms.valueobject.User;

@Controller
public class UserController {
	Logger logger=Logger.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ModelAndView getAllUserDetails()
	{
		logger.info("UserController.getAllUserDetails() started ");
		ModelAndView model=new ModelAndView("users");
	
		List<User> userList=userService.getAllUserDetails();
		model.addObject("userList", userList);
		
		logger.info("UserController.getAllUserDetails() end ");
		return model;
	}

	@RequestMapping(value="/user/edit", method=RequestMethod.GET)
	public ModelAndView editUserDetails(HttpServletRequest  request)
	{
		logger.info("UserController.editUserDetails() started ");
		ModelAndView model=new ModelAndView("edituser");
	
		User user=(User) request.getSession().getAttribute("user");
		model.addObject("user", user);
		
		logger.info("UserController.editUserDetails() end ");
		return model;
	}
	}
