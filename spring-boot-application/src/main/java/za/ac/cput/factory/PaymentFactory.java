package za.ac.cput.factory;

import za.ac.cput.domain.Payment;

import java.time.LocalDateTime;

/* PaymentFactory.java
      Payment Factory class
     Author: Cameron Savage (230582567)
     Date: 15 May 2025
     */

public class PaymentFactory {
    public static Payment createPayment(String paymentID,
                                        double amount,
                                        LocalDateTime date,
                                        String paymentMethod,
                                        String status,
                                        String transactionID) {
        //will add helper stuff when helper class is added


        return new Payment.PaymentBuilder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setPaymentDate(date)
                .setPaymentMethod(paymentMethod)
                .setStatus(status)
                .setTransactionID(transactionID)
                .build();


    }
}
