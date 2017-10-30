package com.TaskTrackerOOSDApp.service;

import java.util.List;

import com.TaskTrackerOOSDApp.model.Task;

public interface TaskService {
	
	List<Task> retrieveAll();

	void createTask(Task task);
	
	void updateAssignedTo(Integer taskId, String username);
	
	void updateStatus(Integer taskId, String status);

}
