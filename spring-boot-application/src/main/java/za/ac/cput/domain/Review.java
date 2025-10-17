package za.ac.cput.domain;

/* Review.java
      Review POJO class
     Author: Cameron Savage (230582567)
     Date: 11 May 2025
     */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    private String reviewID;
    private int rating;
    private String comment;
    private LocalDateTime dateSubmitted;

    //  @OneToOne
//    @JoinColumn(name = "user_id") // Foreign Key column
//    private User user;
    public Review() {
    }

    private Review(ReviewBuilder builder) {
        this.reviewID = builder.reviewID;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.dateSubmitted = builder.dateSubmitted;
    }

    public String getReviewID() {
        return reviewID;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID='" + reviewID + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", dateSubmitted=" + dateSubmitted +
                '}';
    }

    public static class ReviewBuilder {
        private String reviewID;
        private int rating;
        private String comment;
        private LocalDateTime dateSubmitted;

        public ReviewBuilder() {
        }

        public Review.ReviewBuilder setReviewID(String reviewID) {
            this.reviewID = reviewID;
            return this;
        }

        public Review.ReviewBuilder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Review.ReviewBuilder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Review.ReviewBuilder setDateSubmitted(LocalDateTime dateSubmitted) {
            this.dateSubmitted = dateSubmitted;
            return this;
        }

        public ReviewBuilder(String reviewID, int rating, String comment, LocalDateTime dateSubmitted) {
            this.reviewID = reviewID;
            this.rating = rating;
            this.comment = comment;
            this.dateSubmitted = dateSubmitted;
        }
        public ReviewBuilder copy(Review review) {
            this.reviewID = review.reviewID;
            this.rating = review.rating;
            this.comment = review.comment;
            this.dateSubmitted = review.dateSubmitted;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}