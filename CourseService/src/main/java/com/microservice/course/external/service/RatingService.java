package com.microservice.course.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.course.entity.Rating;

@FeignClient(name= "RATING-SERVICE")
public interface RatingService {
  
	@GetMapping("/ratings/courses/{courseId}")
	List<Rating> getRatings(@PathVariable String courseId);
	
	@GetMapping("/ratings/courses/{coursesId}")
	List<Rating> getCourses(@PathVariable String coursesId);
	
}