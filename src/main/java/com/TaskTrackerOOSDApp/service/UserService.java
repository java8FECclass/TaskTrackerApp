package com.TaskTrackerOOSDApp.service;

import com.TaskTrackerOOSDApp.model.User;

//This inferace consists abstract methods like IsUSerValid
//Input to this method would be user object provided by front-end layer
//example isUserValid(User user); -> return boolean
public interface UserService {

	boolean isUserValid(User user);

	boolean doesUserExist(User user);

	boolean isUserAdmin(User user);

}
