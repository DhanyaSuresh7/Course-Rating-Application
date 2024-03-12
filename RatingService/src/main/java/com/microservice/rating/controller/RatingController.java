package com.microservice.rating.controller;

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

import com.microservice.rating.entity.Rating;
import com.microservice.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> findAllRatings(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getUserById(@PathVariable String ratingId){
		return ResponseEntity.ok(ratingService.getRating(ratingId));
	}
	
	@DeleteMapping("/{ratingId}")
	public ResponseEntity<String> deleteUserById(@PathVariable String ratingId){
		return ResponseEntity.ok(ratingService.deleteRatingId(ratingId));
	}
	
	@PutMapping("/{ratingId}")
	public ResponseEntity<Rating> updateUserById(@PathVariable String ratingId, @RequestBody Rating rating){
		return ResponseEntity.ok(ratingService.updateRatingById(ratingId, rating));
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}

	@GetMapping("/courses/{courseId}")
	public ResponseEntity<List<Rating>> getRatingByCourseId(@PathVariable String courseId) {
		return ResponseEntity.ok(ratingService.getRatingByCourseId(courseId));
	}
	
}
