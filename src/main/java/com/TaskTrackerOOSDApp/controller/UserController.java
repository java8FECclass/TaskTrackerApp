package com.TaskTrackerOOSDApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public ModelAndView login(User userLoginFormObject)  {
		ModelAndView model = null;
		//if user entered info matches the data in the db redirect the user to view task page
		//when the service code is ready we can pass the user object to the service isUserValid method and get true or false
		if(userLoginFormObject.getName().equals(getMockDBUser().getName()) 
				&& userLoginFormObject.getPassword().equals(getMockDBUser().getPassword())) {
			model = new ModelAndView("tasks");
		}
		else {
			model = new ModelAndView("home");
			model.addObject("error", "Password or Username is invalid: Try logging in again");
		}
		return model;
		
	}
	
	public User getMockDBUser() {
		User dbMockUser = new User();
		dbMockUser.setName("admin");
		dbMockUser.setPassword("pass");
		return dbMockUser;
	}

}
