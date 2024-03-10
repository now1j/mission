package com.zb.mission.service;

import com.zb.mission.entity.Review;
import com.zb.mission.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }


}
