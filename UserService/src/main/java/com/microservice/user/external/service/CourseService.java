package com.microservice.user.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.user.entity.Course;

@FeignClient(name= "COURSE-SERVICE")
public interface CourseService {

	@GetMapping("/courses/users/{courseId}")
	Course getCourseByIdForUser(@PathVariable String courseId);
}

