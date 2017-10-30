package com.TaskTrackerOOSDApp.dao;

import java.util.List;

import com.TaskTrackerOOSDApp.model.Task;

public interface TaskDAO {

	// retrieve List of Tasks from task table
	List<Task> retrieveAlltasks();

	// creating a new entry using into the task table
	void createtask(Task task);
	
	// RETRIEVE one task by taskID
	Task retrieveOne(Integer taskId);
	
	// UPDATE a Task based on status and assignedto info passed by service
	void updateTask(Task task);
}
