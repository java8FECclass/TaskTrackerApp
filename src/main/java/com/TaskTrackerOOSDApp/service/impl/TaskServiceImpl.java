package com.TaskTrackerOOSDApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskTrackerOOSDApp.dao.TaskDAO;
import com.TaskTrackerOOSDApp.model.Task;
import com.TaskTrackerOOSDApp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private static final String DEFAULT_STATUS = "OPEN";
	private static final String DEFAULT_ASSIGNEDTO = "UN-ASSIGNED";

	// Autowired the completed DAO to the service layer ;)
	@Autowired
	TaskDAO taskDAO;
	
	// 1) sets a call to the DAO layer to get a list containing all the tasks of the task database
	// 2) returns the list to the UI level so that the tasklist page can be rendered
	// Override is used to ensure no common errors are made when compiling
	@Override
	public List<Task> retrieveAll() {
		return taskDAO.retrieveAlltasks();
	}
	
	// 1) receives a Task object from the UI level 
	// 2) sets default values to the assigned to and status variables (unassigned and not started)
	// 3) calls the DAO layer to add the task to the database
	@Override
	public void createTask(Task task) {
		task.setStatus(DEFAULT_STATUS);
		task.setAssignedTo(DEFAULT_ASSIGNEDTO);
		taskDAO.createtask(task);

	}
	
	// 1) receives a Task Id and user name from the UI layer
	// 2) calls the DAO layer with task id(task table key) to retrieve the task object
	// 3) updates the 'assigned to' name instance variable with the user name that was passed by the UI layer
	// 4) call the DAO layer to update the task database
	@Override
	public void updateAssignedTo(Integer taskId, String username) {
		Task task = taskDAO.retrieveOne(taskId);
		task.setAssignedTo(username);
		taskDAO.updateTask(task);

	}
	
	// 1) receives a Task Id and status from the UI layer
	// 2) calls the DAO layer with task id(task table key) to retrieve the task object
	// 3) updates the 'status' instance variable with the status that was passed by the UI layer
	// 4) call the DAO layer to update the task database
	@Override
	public void updateStatus(Integer taskId, String status) {
		Task task = taskDAO.retrieveOne(taskId);
		task.setStatus(status);
		taskDAO.updateTask(task);

	}
	
	// 1) receives a Task Id and status from the UI layer
	// 2) calls the DAO layer with task id(task table key) to retrieve the task object
	@Override
	public Task retrieveTask(Integer taskId) {	
		return taskDAO.retrieveOne(taskId);
	}

}
