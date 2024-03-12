package com.microservice.rating.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.entity.Rating;
import com.microservice.rating.exception.ResourceNotFoundException;
import com.microservice.rating.repository.RatingRepository;
import com.microservice.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRating(String ratingId) {
		return ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating with given id is not found: " + ratingId));
	}

	@Override
	public String deleteRatingId(String ratingId) {
		 ratingRepository.deleteById(ratingId);
		 return "Deleted Successfully";
	}

	@Override
	public Rating updateRatingById(String ratingId, Rating updatedRating) {
		return ratingRepository.findById(ratingId).map(
				existingRating->{
					existingRating.setCourseId(updatedRating.getCourseId());
					existingRating.setUserId(updatedRating.getUserId());
					existingRating.setRating(updatedRating.getRating());
					existingRating.setFeedback(updatedRating.getFeedback());
					return ratingRepository.save(existingRating);
				}).orElseThrow(() -> new ResourceNotFoundException("Rating with given id is not found: " + ratingId));
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByCourseId(String courseId) {
		return ratingRepository.findByCourseId(courseId);
	}

}
