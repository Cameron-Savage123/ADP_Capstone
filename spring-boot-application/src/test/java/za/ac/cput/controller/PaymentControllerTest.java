package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* PaymentControllerTest.java
      Payment Controller Test class
     Author: Cameron Savage (230582567)
     Date: 29 August 2025
     */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentControllerTest {

    private static Payment payment;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/TutorMe-ADP3-Capstone/spring-boot-application/payment";
    }

    @BeforeAll
    public static void setup() {
        payment = PaymentFactory.createPayment(
                "P001",                 // paymentID
                500.00,                 // amount
                LocalDateTime.now(),    // paymentDate
                "CASH",                 // paymentMethod
                "SUCCESS",              // status
                "TXN123"                // transactionID
        );
    }

    @Test
    @Order(1)
    void createPayment() {
        String url = getBaseUrl() + "/create";
        ResponseEntity<Payment> response = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(response.getBody());
        payment = response.getBody();
        System.out.println("Created_Payment: " + payment);
    }

    @Test
    @Order(2)
    void readPayment() {
        String url = getBaseUrl() + "/read/" + payment.getPaymentID();
        ResponseEntity<Payment> response = restTemplate.getForEntity(url, Payment.class);
        assertNotNull(response.getBody());
        assertEquals(payment.getPaymentID(), response.getBody().getPaymentID());
        System.out.println("Read_Payment: " + response.getBody());
    }

    @Test
    @Order(3)
    void updatePayment() {
        Payment updatedPayment = new Payment.PaymentBuilder()
                .copy(payment)
                .setAmount(750.00)
                .build();

        String url = getBaseUrl() + "/update";
        ResponseEntity<Payment> response = restTemplate.exchange(
                url, HttpMethod.PUT, new HttpEntity<>(updatedPayment), Payment.class);

        assertNotNull(response.getBody());
        assertEquals(updatedPayment.getAmount(), response.getBody().getAmount());
        System.out.println("Updated_Payment: " + response.getBody());
    }

    @Test
    @Order(4)
    void deletePayment() {
        String url = getBaseUrl() + "/delete/" + payment.getPaymentID();
        restTemplate.delete(url);

        ResponseEntity<Payment> response = restTemplate.getForEntity(getBaseUrl() + "/read/" + payment.getPaymentID(), Payment.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted_Payment: Status " + response.getStatusCode());
    }
}