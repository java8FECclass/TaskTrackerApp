package com.TaskTrackerOOSDApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TaskTrackerOOSDApp.model.User;

//This class is the controller that maps user request URLS to java 
//methods by leveraging spring MVC
@Controller
public class UserController {
	
	@RequestMapping(value = "/")
	public ModelAndView login(ModelAndView model)  {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("home");
		return model;
	}

}
