package com.microservice.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	private String userId;
	
	private String name;
	
	private String email;
	
	private String qualification;
	
	private Long contactnumber;
}
