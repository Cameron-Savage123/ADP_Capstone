package za.ac.cput.factory;

import za.ac.cput.domain.Review;

import java.time.LocalDateTime;

/* ReviewFactory.java
      Review Factory class
     Author: Cameron Savage (230582567)
     Date: 15 May 2025
     */

public class ReviewFactory {
    public static Review createReview(String reviewID,
                                      int rating,
                                      String comment,
                                      LocalDateTime dateSubmitted) {
//will add helper stuff when helper class is added

        return new Review.ReviewBuilder()
                .setReviewID(reviewID)
                .setRating(rating)
                .setComment(comment)
                .setDateSubmitted(dateSubmitted)
                .build();

    }

}