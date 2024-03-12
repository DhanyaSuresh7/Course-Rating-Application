package com.microservice.user.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.entity.Course;
import com.microservice.user.entity.Rating;
import com.microservice.user.entity.User;
import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.external.service.CourseService;
import com.microservice.user.external.service.RatingService;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private CourseService courseService;

	@Override
	public User saveUser(User user) {
		// to generate unique id in string
		String randomeUserId = UUID.randomUUID().toString();
		user.setUserId(randomeUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

//	@Override
//	public User getUser(String userId) {
//		User user = userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + userId));
//		List<Rating> ratings = ratingService.getRatings(userId);
//		List<Course> courseList = ratings.stream().map(rating -> {
//			Course course = courseService.getCourse(rating.getCourseId());
//			return course;
//		}).collect(Collectors.toList());
//		user.setCourses(courseList);
//		return user;
//	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + userId));
		List<Rating> ratings = ratingService.getRatings(userId);
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			Course course = courseService.getCourseByIdForUser(rating.getCourseId());
			rating.setCourse(course);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}
	
	@Override
	public User getUserForCourse(String userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + userId));
	}

	
	@Override
	public String deleteUserId(String userId) {
		userRepository.deleteById(userId);
		return "Deleted Successfully";
	}

	@Override
	public User updateUserById(String userId, User updatedUser) {
		return userRepository.findById(userId).map(existingUser -> {
			existingUser.setName(updatedUser.getName());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setQualification(updatedUser.getQualification());
			existingUser.setContactnumber(updatedUser.getContactnumber());
			existingUser.setRatings(updatedUser.getRatings());
			return userRepository.save(existingUser);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
	}

	@Override
	public User getUserById(String userId) {	
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + userId));
		 
	}

}
