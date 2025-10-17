package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* ReviewControllerTest.java
      Review Controller Test class
     Author: Cameron Savage (230582567)
     Date: 29 August 2025
     */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewControllerTest {

    private static Review review;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/TutorMe-ADP3-Capstone/spring-boot-application/review";
    }

    @BeforeAll
    public static void setup() {
        review = ReviewFactory.createReview(
                "R001",                // reviewID
                5,                     // rating
                "Excellent service!",  // comment
                LocalDateTime.now()    // dateSubmitted
        );
    }

    @Test
    @Order(1)
    void createReview() {
        String url = getBaseUrl() + "/create";
        ResponseEntity<Review> response = restTemplate.postForEntity(url, review, Review.class);
        assertNotNull(response.getBody());
        review = response.getBody(); // store created review
        System.out.println("Created_Review: " + review);
    }

    @Test
    @Order(2)
    void readReview() {
        String url = getBaseUrl() + "/read/" + review.getReviewID();
        ResponseEntity<Review> response = restTemplate.getForEntity(url, Review.class);
        assertNotNull(response.getBody());
        assertEquals(review.getReviewID(), response.getBody().getReviewID());
        System.out.println("Read_Review: " + response.getBody());
    }

    @Test
    @Order(3)
    void updateReview() {
        Review updatedReview = new Review.ReviewBuilder()
                .copy(review)
                .setComment("Great service, but was incoherent at times.") // update comment
                .build();

        String url = getBaseUrl() + "/update";
        ResponseEntity<Review> response = restTemplate.exchange(
                url, HttpMethod.PUT, new HttpEntity<>(updatedReview), Review.class);

        assertNotNull(response.getBody());
        assertEquals(updatedReview.getComment(), response.getBody().getComment());
        System.out.println("Updated_Review: " + response.getBody());
    }

    @Test
    @Order(4)
    void deleteReview() {
        String url = getBaseUrl() + "/delete/" + review.getReviewID();
        restTemplate.delete(url);

        ResponseEntity<Review> response = restTemplate.getForEntity(getBaseUrl() + "/read/" + review.getReviewID(), Review.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted_Review: Status " + response.getStatusCode());
    }
}