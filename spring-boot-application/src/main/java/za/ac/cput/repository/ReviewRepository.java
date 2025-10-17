package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Review;

/* ReviewRepository.java
      Review Repository class
     Author: Cameron Savage (230582567)
     Date: 20 May 2025
     */

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
}
