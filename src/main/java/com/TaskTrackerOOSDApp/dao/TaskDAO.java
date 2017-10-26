package com.TaskTrackerOOSDApp.dao;

import java.util.List;

import com.TaskTrackerOOSDApp.model.Task;

public interface TaskDAO {
	
	// retrieve List of Tasks from task table
	List<Task> retrieveAlltasks();
	

}
