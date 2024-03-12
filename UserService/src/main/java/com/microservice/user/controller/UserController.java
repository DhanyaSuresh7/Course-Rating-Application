package com.microservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.entity.User;
import com.microservice.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	@GetMapping("/courses/{userId}")
	public ResponseEntity<User> getUserForCourse(@PathVariable String userId){
		return ResponseEntity.ok(userService.getUserForCourse(userId));
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable String userId){
		return ResponseEntity.ok(userService.deleteUserId(userId));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUserById(@PathVariable String userId, @RequestBody User user){
		return ResponseEntity.ok(userService.updateUserById(userId, user));
	}
}
