package com.TaskTrackerOOSDApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TaskTrackerOOSDApp.model.User;
import com.TaskTrackerOOSDApp.service.UserService;

//This class is the controller that maps user request URLS to java 
//methods by leveraging spring MVC
@Controller
public class UserController {
	// auto-wiring user service is injecting userService dependency into this
	// controller
	@Autowired
	UserService userService;

	// (/) method (GET) is the FIRST method that is called when the user accesses
	// our app using
	// the root context and display's the home page, which is nothing but "login"
	@RequestMapping(value = "/")
	public ModelAndView login(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("home");
		return model;
	}

	// (/login) method (POST) is mapped to /login URL where user post/submits the
	// form
	// which is mapped to user object and we pass to service
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(User userLoginFormObject) {
		ModelAndView model = null;
		// passing the user login form object logic that we captured from user to
		// service to validate username and password
		// when we add the employee roles feature we will need to be another boolean
		// method
		// add an else if statement for both possible returns of admin or task page
		if (!userService.doesUserExist(userLoginFormObject)) {
			model = new ModelAndView("home");
			model.addObject("error", "Username does not exist");
		}

		else if (userService.isUserValid(userLoginFormObject)) {
			if (userService.isUserAdmin(userLoginFormObject)) {
				model = new ModelAndView("redirect:/adminTasks");
			} else {
				model = new ModelAndView("redirect:/empTasks");
			}

		}

		else {
			model = new ModelAndView("home");
			model.addObject("error", "Password or Username is invalid: Try logging in again");
		}
		return model;

	}

}
