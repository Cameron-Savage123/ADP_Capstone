package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;
/* ReviewService.java
      Review service class
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */



@Service
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    //@Override
   // public Review readReview(String reviewID) {
   //     return reviewRepository.findById(reviewID).orElse(null);
   // }
    @Override
    public Optional<Review> readReview(String id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(String reviewID) {
        reviewRepository.deleteById(reviewID);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}


