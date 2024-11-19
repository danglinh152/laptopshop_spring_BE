package com.twohdcd.Laptopshop.service;

import com.twohdcd.Laptopshop.domain.Review;
import com.twohdcd.Laptopshop.repository.ReviewRepository;
import com.twohdcd.Laptopshop.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public Review addReview(Review Review) {
        return reviewRepository.save(Review);
    }

    public Review updateReview(Review Review) {
        return reviewRepository.save(Review);
    }

    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }
}
