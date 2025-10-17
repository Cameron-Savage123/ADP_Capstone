package za.ac.cput.service;
/* PaymentServiceTest.java
   Test class for PaymentService
   Author: Cameron Savage (230582567)
   Date: 31 August 2025
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    @Autowired
    private PaymentService service;

    private static Payment payment = PaymentFactory.createPayment(
            "P001",
            750.00,
            LocalDateTime.now(),
            "Credit Card",
            "Successful",
            "TXN123456"
    );

    @Test
    void a_create() {
        Payment created = service.createPayment(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentID(), created.getPaymentID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Optional<Payment> read = service.readPayment(payment.getPaymentID());
        assertTrue(read.isPresent());
        System.out.println("Read: " + read.get());
    }

    @Test
    void c_update() {
        Payment updated = PaymentFactory.createPayment(
                payment.getPaymentID(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getPaymentMethod(),
                "Refunded", // changed status
                payment.getTransactionID()
        );

        Payment result = service.updatePayment(updated);
        assertNotNull(result);
        assertEquals("Refunded", result.getStatus());
        System.out.println("Updated: " + result);
    }

    @Test
    void d_getAll() {
        System.out.println("All Payments: " + service.getAllPayments());
        assertNotNull(service.getAllPayments());
    }

    @Test
    void e_delete() {
        service.deletePayment(payment.getPaymentID());
        Optional<Payment> deleted = service.readPayment(payment.getPaymentID());
        assertFalse(deleted.isPresent());
        System.out.println("Deleted: " + payment.getPaymentID());
    }
}