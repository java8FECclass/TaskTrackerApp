package com.TaskTrackerOOSDApp.service;

import java.util.ArrayList;

import com.TaskTrackerOOSDApp.model.Task;
import com.TaskTrackerOOSDApp.model.User;

public interface TaskService {
	ArrayList <Task> retrieveAll();
	Task retrieveOne(Integer taskid);
	Task createTask(User user);
	Task updateStatus(User user);



}
