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

}
