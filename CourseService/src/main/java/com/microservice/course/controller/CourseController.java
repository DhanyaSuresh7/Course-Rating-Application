package com.microservice.course.controller;

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

import com.microservice.course.entity.Course;
import com.microservice.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.saveCourse(course));		
	}
	
	@GetMapping
	public ResponseEntity<List<Course>> findAllCourses(){
		return ResponseEntity.ok(courseService.getAllCourses());
	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable String courseId){
		return ResponseEntity.ok(courseService.getCourse(courseId));
	}
	
	@GetMapping("/users/{courseId}")
	public ResponseEntity<Course> getCourseByIdForUser(@PathVariable String courseId){
		return ResponseEntity.ok(courseService.getCourseForUser(courseId));
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<String> deleteCourseById(@PathVariable String courseId){
		return ResponseEntity.ok(courseService.deleteCourseId(courseId));
	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<Course> updateCourseById(@PathVariable String courseId, @RequestBody Course course){
		return ResponseEntity.ok(courseService.updateCourseById(courseId, course));
	}
}
