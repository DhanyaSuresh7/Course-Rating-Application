package com.microservice.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

	private String ratingId;

	private String userId;

	private String courseId;

	private int rating;

	private String feedback;
	
	private Course course;

}
