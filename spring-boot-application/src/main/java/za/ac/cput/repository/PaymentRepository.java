package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;

/* PaymentRepository.java
      Payment Repository class
     Author: Cameron Savage (230582567)
     Date: 20 May 2025
     */

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
