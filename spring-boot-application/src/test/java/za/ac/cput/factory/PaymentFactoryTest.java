package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* PaymentFactoryTest.java
      Payment Factory Test class
     Author: Cameron Savage (230582567)
     Date: 29 June 2025
     */


class PaymentFactoryTest {

    @Test
    void createPayment() {
        LocalDateTime paymentDate = LocalDateTime.of(2027, 10, 4, 0, 0);
    Payment payment = PaymentFactory.createPayment("12345",100,paymentDate,"Card","Completed","5214");
    assertNotNull(payment);
        System.out.println(payment);
    }
}

