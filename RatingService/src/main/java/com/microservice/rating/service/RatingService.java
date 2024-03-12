package com.microservice.rating.service;

import java.util.List;

import com.microservice.rating.entity.Rating;

public interface RatingService {

	// create
	Rating saveRating(Rating rating);

	// get all ratings
	List<Rating> getAllRatings();

	// get single rating of given ratingId
	Rating getRating(String ratingId);

	// get all by UserId
	List<Rating> getRatingByUserId(String userId);

	// get all by UserId
	List<Rating> getRatingByCourseId(String courseId);

	// delete
	String deleteRatingId(String ratingId);

	// update
	Rating updateRatingById(String ratingId, Rating rating);
}
