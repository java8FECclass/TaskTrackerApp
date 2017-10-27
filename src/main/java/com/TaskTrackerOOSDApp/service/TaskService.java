package com.TaskTrackerOOSDApp.service;

import java.util.List;

import com.TaskTrackerOOSDApp.model.Task;
import com.TaskTrackerOOSDApp.model.User;

public interface TaskService {
	List<Task> retrieveAll();

	void createTask(Task task);

}
