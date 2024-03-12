package com.microservice.course.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

	@Id
	private String courseId;

	private String name;

	private Long cost;

	private String description;

	@Transient
	private List<Rating> ratings = new ArrayList<>();
}
