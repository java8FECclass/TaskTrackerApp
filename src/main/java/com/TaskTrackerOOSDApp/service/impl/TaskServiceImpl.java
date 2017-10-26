package com.TaskTrackerOOSDApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TaskTrackerOOSDApp.model.Task;
import com.TaskTrackerOOSDApp.model.User;
import com.TaskTrackerOOSDApp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Override
	public List<Task> retrieveAll() {
		//we will replace getAllMockTasks() this with taskDao.retrieveAllTasks(); when the DAO is ready
		//when dao is ready delete the getAllMockTasks()
		return getAllMockTasks();
		
	}
	
	
	//this method is used to mock the DAO behavior as the DAO code has not been pushed yet
	List<Task> getAllMockTasks(){
		//creating two mock task objects and setting mock data
		Task task1 = new Task();
		task1.setTaskId(1);
		task1.setTaskDescription("run");
		task1.setStatus("Unassigned");
		task1.setAssignedTo("george");
		//creating two mock task objects and setting mock data
		Task task2 = new Task();
		task2.setTaskId(2);
		task2.setTaskDescription("jog");
		task2.setStatus("assigned");
		task2.setAssignedTo("dave");
		//adding both the tasks to the list
		List<Task> taskList = new ArrayList<Task>();
		taskList.add(task1);
		taskList.add(task2);
		
		return taskList;
		
		
	}

	@Override
	public Task retrieveOne(Integer taskid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task createTask(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateStatus(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
