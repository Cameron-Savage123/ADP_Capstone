package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* ReviewFactoryTest.java
      Review Factory Test class
     Author: Cameron Savage (230582567)
     Date: 29 June 2025
     */

class ReviewFactoryTest {

    @Test
    void createReview() {
        LocalDateTime dateSubmitted = LocalDateTime.of(2027, 10, 4, 0, 0);
        Review review= ReviewFactory.createReview("1245",8,"He was very polite",dateSubmitted);
        assertNotNull(review);
        System.out.println(review);
    }
}
