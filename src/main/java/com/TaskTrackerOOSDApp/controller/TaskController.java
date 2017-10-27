package com.TaskTrackerOOSDApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TaskTrackerOOSDApp.model.Task;
import com.TaskTrackerOOSDApp.service.TaskService;
//This class is the controller that maps user request URLS to java 
//methods by leveraging spring MVC
@Controller
public class TaskController {
	// auto-wiring task service is injecting taskService dependency into this controller
		@Autowired
		TaskService taskService;
	//
	//we are created an array task list and getting the content of the data for service layer and passing it to the task page
		
		@RequestMapping(value = "/adminTasks")
		public ModelAndView viewTasks(ModelAndView model)  {
			List<Task> taskList = taskService.retrieveAll();
			model.addObject("taskList", taskList );
			model.setViewName("adminTasks");
			return model;
		}
		//if admin user pushes create task button then it goes to task creation page(dummypage)
		
		@RequestMapping(value = "/taskForm")
		public ModelAndView createTask(ModelAndView model)  {
			model.setViewName("createTask");
			return model;		
			}
	
	//

}
