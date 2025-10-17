package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import java.util.List;
import java.util.Optional;
/* IPaymentService.java
      Payment service interface
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */

public interface IPaymentService {
    Payment createPayment(Payment payment);
    Optional<Payment> readPayment(String id);
    Payment updatePayment(Payment payment);
    void deletePayment(String id);
    List<Payment> getAllPayments();
}
