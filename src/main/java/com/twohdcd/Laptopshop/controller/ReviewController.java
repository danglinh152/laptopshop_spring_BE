package com.twohdcd.Laptopshop.controller;

import com.twohdcd.Laptopshop.domain.Review;
import com.twohdcd.Laptopshop.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        if (reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        Review review = reviewService.getReviewById(id);
        if (review == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(review);
    }


    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.addReview(review));
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReviewById(@RequestBody Review reviewParam, @PathVariable int id) {
        Review review = reviewService.getReviewById(id);
        review.setRating(reviewParam.getRating());
        review.setComment(reviewParam.getComment());
        return ResponseEntity.ok(reviewService.updateReview(review));
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable int id) {
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully");
    }
}
