package com.TaskTrackerOOSDApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TaskTrackerOOSDApp.model.Task;
import com.TaskTrackerOOSDApp.service.TaskService;

//This class is the controller that maps user request URLS to java 
//methods by leveraging spring MVC
@Controller
public class TaskController {
	// auto-wiring task service is injecting taskService dependency into this
	// controller
	@Autowired
	TaskService taskService;
	
	// we are created an array task list and getting the content of the data for
	// service layer and passing it to the task page
	@RequestMapping(value = "/adminTasks")
	public ModelAndView viewTasks(ModelAndView model) {
		List<Task> taskList = taskService.retrieveAll();
		model.addObject("taskList", taskList);
		model.setViewName("adminTasks");
		return model;
	}
	
	// if admin user pushes create task button then it goes to task creation
	// page which would display task form. 
	@RequestMapping(value = "/taskForm")
	public ModelAndView createTask(ModelAndView model) {
		Task task = new Task();
		model.addObject("task", task);
		model.setViewName("createTask");
		return model;
	}

	@RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public ModelAndView createTask(Task taskformobject) {
		ModelAndView model = null;
		taskService.createTask(taskformobject);
		model = new ModelAndView("redirect:/adminTasks");
		return model;

	}

	@RequestMapping(value = "/empTasks")
	public ModelAndView viewEmpTasks(ModelAndView model) {
		List<Task> taskList = taskService.retrieveAll();
		model.addObject("taskList", taskList);
		model.setViewName("empTasks");
		return model;

	}
	
	@RequestMapping(value = "/viewTask/{taskId}")
	public ModelAndView viewEmpTasks(ModelAndView model, @PathVariable Integer taskId) {
		Task task = taskService.retrieveTask(taskId);
		model.addObject("task", task);
		model.setViewName("updateTask");
		return model;

	}
}
