package com.microservice.course.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.course.entity.User;


@FeignClient(name= "USER-SERVICE")
public interface UserService {

	@GetMapping("/users/courses/{userId}")
	User getUserForCourse(@PathVariable String userId);
}

