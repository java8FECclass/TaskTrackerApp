package com.TaskTrackerOOSDApp.dao;

import java.util.List;

import com.TaskTrackerOOSDApp.model.Task;

public interface TaskDAO {

	// retrieve List of Tasks from task table
	List<Task> retrieveAlltasks();

	// creating a new entry using createtask into the task table
	void createtask(Task task);
	
	// RETRIEVE only one record by task ID
	Task retrieveOne(Integer taskId);
	
	// UPDATE a Task based on questions to be answered later
	void updateTask(Task task);
}
