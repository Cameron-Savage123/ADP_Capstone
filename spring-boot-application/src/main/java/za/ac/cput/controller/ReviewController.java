package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Review;
import za.ac.cput.service.ReviewService;

import java.util.List;
/* ReviewController.java
      Review Controller Class
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

  //  @GetMapping("/read/{reviewID}")
  //  public Review readReview(@PathVariable String reviewID) {
  //      return reviewService.readReview(reviewID);
  //  }
  @GetMapping("/read/{reviewID}")
  public Review readReview(@PathVariable String reviewID) {
      return reviewService.readReview(reviewID)
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
  }

    @PutMapping("/update")
    public Review updateReview(@RequestBody Review review) {
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/delete/{reviewID}")
    public void deleteReview(@PathVariable String reviewID) {
        reviewService.deleteReview(reviewID);
    }

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
}