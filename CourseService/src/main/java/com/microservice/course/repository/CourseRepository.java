package com.microservice.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course,String>{

}
