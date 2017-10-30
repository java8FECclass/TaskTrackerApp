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

	// Override is used to ensure no common errors are made when compiling
	@Override
	public List<Task> retrieveAll() {
		return taskDAO.retrieveAlltasks();
	}

	@Override
	public void createTask(Task task) {
		task.setStatus(DEFAULT_STATUS);
		task.setAssignedTo(DEFAULT_ASSIGNEDTO);
		taskDAO.createtask(task);

	}

	@Override
	public void updateAssignedTo(Integer taskId, String username) {
		Task task = taskDAO.retrieveOne(taskId);
		task.setAssignedTo(username);
		taskDAO.updateTask(task);

	}

	@Override
	public void updateStatus(Integer taskId, String status) {
		Task task = taskDAO.retrieveOne(taskId);
		task.setStatus(status);
		taskDAO.updateTask(task);

	}

}
