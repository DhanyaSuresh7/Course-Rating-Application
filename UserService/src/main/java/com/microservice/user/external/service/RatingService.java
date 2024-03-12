package com.microservice.user.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.user.entity.Rating;

@FeignClient(name= "RATING-SERVICE")
public interface RatingService {
  
	@GetMapping("/ratings/users/{userId}")
	List<Rating> getRatings(@PathVariable String userId);
	
	@GetMapping("/ratings/courses/{coursesId}")
	List<Rating> getCourses(@PathVariable String coursesId);
	
}
