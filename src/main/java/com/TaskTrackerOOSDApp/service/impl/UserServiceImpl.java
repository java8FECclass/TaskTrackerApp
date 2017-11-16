package com.TaskTrackerOOSDApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskTrackerOOSDApp.dao.UserDao;
import com.TaskTrackerOOSDApp.model.User;
import com.TaskTrackerOOSDApp.service.UserService;

//This class implements the UserService interface this is where the
//logic to check whether the user isValid exists
//Service depends on DAO to retrieve data from DB and verify
//if the user is valid
//use spring to inject DAO dependency to service

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	// 1) Receives a User object from the UI level 2) sets a call to the DAO layer to see if there if there is a record
	// on the user data base with a matching user name and user password 3) sends back a true or false value to the UI level which either 
	// logs the user into the app or goes back to the logon page with an error message
	@Override
	public boolean isUserValid(User user) {
		String userLoginName = user.getName();
		String userLoginPassword = user.getPassword();
		// call UserDao interface
		// userDao.retrieveByUserName(userLoginName);
		User dbUser = userDao.retrieveByUserName(userLoginName);
		String userDbName = dbUser.getName();
		String userDbPassword = dbUser.getPassword();

		if (userLoginName.equals(userDbName) && userLoginPassword.equals(userDbPassword)) {
			return true;
		} else {
			return false;
		}

	}
	
	// 1) Receives a User object from the UI level 2) sets a call to the DAO layer to see if there if there is a record
	// on the user data base with matching user name 3) sends back a true or false value to the UI level which either 
	// goes back to the logon page with an error message or continues validating the login by checking password
	@Override
	public boolean doesUserExist(User user) {
		String userCheckName = user.getName();
		// call UserDao interface
		// userDao.retrieveByUserName(userLoginName);
		User dbUser = userDao.retrieveByUserName(userCheckName);
		if (dbUser == null) {
			return false;
		} else {
			return true;
		}

	}
	
	// 1) Receives a User object from the UI level  2) sends back a true or false value to the UI level which either 
	// renders either the admin or employee version of the task list page 
	@Override
	public boolean isUserAdmin(User user) {

		if (user.getName().equals("admin")) {
			return true;
		}

		else {
			return false;
		}
	}

}
