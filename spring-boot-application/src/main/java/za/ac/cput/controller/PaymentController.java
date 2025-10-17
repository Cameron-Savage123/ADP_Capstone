package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.List;

/* PaymentController.java
      Payment Controller Class
     Author: Cameron Savage (230582567)
     Date: 27 August 2025
     */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping("/read/{paymentID}")
    public Payment readPayment(@PathVariable String paymentID) {
        return paymentService.readPayment(paymentID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found"));
    }

    @PutMapping("/update")
    public Payment updatePayment(@RequestBody Payment payment) {
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping("/delete/{paymentID}")
    public void deletePayment(@PathVariable String paymentID) {
        paymentService.deletePayment(paymentID);
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/test")
    public String test() {
        return "Payment controller works!";
    }
}