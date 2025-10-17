package za.ac.cput.service;

import za.ac.cput.domain.Review;
import java.util.List;
import java.util.Optional;
/* IReviewService.java
      Review service interface
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */


public interface IReviewService {
    Review createReview(Review review);
    Optional<Review> readReview(String reviewID);
    Review updateReview(Review review);
    void deleteReview(String reviewID);
    List<Review> getAllReviews();
}


