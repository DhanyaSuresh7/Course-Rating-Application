package com.microservice.course.service;

import java.util.List;

import com.microservice.course.entity.Course;


public interface CourseService {

	// create
		Course saveCourse(Course course);

		// get all user
		List<Course> getAllCourses();

		//get single user of given userId
		Course getCourse(String courseId);
		
		Course getCourseForUser(String courseId);

		// delete
		String deleteCourseId(String courseId);

		//update
		Course updateCourseById(String userId,Course course);
}
