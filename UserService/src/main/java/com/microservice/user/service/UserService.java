package com.microservice.user.service;

import java.util.List;

import com.microservice.user.entity.User;

public interface UserService {

	// create
	User saveUser(User user);

	// get all user
	List<User> getAllUsers();

	//get single user of given userId
	User getUser(String userId);
	
	User getUserForCourse(String userId);
	
	User getUserById(String userId);

	// delete
	String deleteUserId(String userId);

	//update
	User updateUserById(String userId,User user);
}