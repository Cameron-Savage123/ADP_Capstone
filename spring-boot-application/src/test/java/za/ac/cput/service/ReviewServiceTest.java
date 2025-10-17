package za.ac.cput.service;

/*
   ReviewServiceTest.java
   Unit test for ReviewService
   Author: Cameron Savage (230582567)
   Date: 31 August 2025
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    private Review review;

    @BeforeEach
    void setUp() {
        review = ReviewFactory.createReview(
                "R001",
                5,
                "Excellent service!",
                LocalDateTime.now()
        );
    }

    @Test
    void create() {
        Review created = reviewService.createReview(review);
        assertNotNull(created);
        assertEquals(review.getReviewID(), created.getReviewID());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        reviewService.createReview(review);
        Optional<Review> read = reviewService.readReview(review.getReviewID());
        assertTrue(read.isPresent());
        assertEquals(5, read.get().getRating());
        System.out.println("Read: " + read.get());
    }

    @Test
    void update() {
        reviewService.createReview(review);
        Review updated = new Review.ReviewBuilder()
                .copy(review)
                .setComment("Updated comment")
                .build();

        Review saved = reviewService.updateReview(updated);
        assertEquals("Updated comment", saved.getComment());
        System.out.println("Updated: " + saved);
    }

    @Test
    void delete() {
        reviewService.createReview(review);
        reviewService.deleteReview(review.getReviewID());
        Optional<Review> deleted = reviewService.readReview(review.getReviewID());
        assertFalse(deleted.isPresent());
        System.out.println("Deleted review with ID: " + review.getReviewID());
    }

    @Test
    void getAll() {
        reviewService.createReview(review);
        List<Review> reviews = reviewService.getAllReviews();
        assertFalse(reviews.isEmpty());
        System.out.println("All Reviews: " + reviews);
    }
}