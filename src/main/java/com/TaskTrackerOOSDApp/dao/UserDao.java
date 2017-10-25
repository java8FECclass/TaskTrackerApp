package com.TaskTrackerOOSDApp.dao;

import com.TaskTrackerOOSDApp.model.User;

//this is dao layer interface that only contains abstract methods
public interface UserDao {
	
	User retrieveByUserName(String name);

}
