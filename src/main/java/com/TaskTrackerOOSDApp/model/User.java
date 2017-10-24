package com.TaskTrackerOOSDApp.model;

//This is the model object(POJO) that helps in capturing user input
//and passing it into different layers, and also helps retrieving 
//data from database 
public class User {
		private String name;
		private String password;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

	}

	

