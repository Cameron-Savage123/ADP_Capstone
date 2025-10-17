package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

/* PaymentService.java
      payment service class
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */


@Service
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
   }
  @Override
  public Optional<Payment> readPayment(String id) {
      return paymentRepository.findById(id);
  }

  //  @Override
  //  public Payment readPayment(String id) {
   //     return paymentRepository.findById(id).orElse(null);
   // }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(String id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
