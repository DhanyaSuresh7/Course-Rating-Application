package com.microservice.course.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.entity.Course;
import com.microservice.course.entity.Rating;
import com.microservice.course.entity.User;
import com.microservice.course.exception.ResourceNotFoundException;
import com.microservice.course.external.service.RatingService;
import com.microservice.course.external.service.UserService;
import com.microservice.course.repository.CourseRepository;
import com.microservice.course.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RatingService ratingService;

	@Autowired
	private UserService userService;
	
	@Override
	public Course saveCourse(Course course) {
		String randomCourseId = UUID.randomUUID().toString();
		course.setCourseId(randomCourseId);
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	@Override
	public Course getCourse(String courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + courseId));
		List<Rating> ratings = ratingService.getRatings(courseId);
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			User user = userService.getUserForCourse(rating.getUserId());
			rating.setUser(user);
			return rating;
		}).collect(Collectors.toList());
		course.setRatings(ratingList);
		return course;
	}
	
	@Override
	public Course getCourseForUser(String courseId) {
		return courseRepository.findById(courseId)
			.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + courseId));
	}

	@Override
	public String deleteCourseId(String courseId) {
		courseRepository.deleteById(courseId);
		return "Deleted Successfully";
	}

	@Override
	public Course updateCourseById(String courserId, Course updatedCourse) {
		return courseRepository.findById(courserId).map(existingCourse -> {
			existingCourse.setName(updatedCourse.getName());
			existingCourse.setDescription(updatedCourse.getDescription());
			existingCourse.setCost(updatedCourse.getCost());
			return courseRepository.save(existingCourse);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + courserId));
	}
	
}
