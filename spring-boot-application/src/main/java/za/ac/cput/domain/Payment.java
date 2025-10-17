package za.ac.cput.domain;

/* Payment.java
      Payment POJO class
     Author: Cameron Savage (230582567)
     Date: 11 May 2025
     */

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    private String paymentID;
    private double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String status;
    private String transactionID;

    //  @OneToOne
//    @JoinColumn(name = "user_id") //
//    private User user;
    public Payment() {
    }

    private Payment(PaymentBuilder builder) {
        this.paymentID = builder.paymentID;
        this.amount = builder.amount;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
        this.status = builder.status;
        this.transactionID = builder.transactionID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", transactionID='" + transactionID + '\'' +
                '}';
    }

    public static class PaymentBuilder {
        private String paymentID;
        private double amount;
        private LocalDateTime paymentDate;
        private String paymentMethod;
        private String status;
        private String transactionID;

        public PaymentBuilder() {
        }

        public Payment.PaymentBuilder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Payment.PaymentBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Payment.PaymentBuilder setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Payment.PaymentBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Payment.PaymentBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Payment.PaymentBuilder setTransactionID(String transactionID) {
            this.transactionID = transactionID;
            return this;
        }


        public PaymentBuilder(String paymentID, double amount, LocalDateTime paymentDate,
                              String paymentMethod, String status, String transactionID) {
            this.paymentID = paymentID;
            this.amount = amount;
            this.paymentDate = paymentDate;
            this.paymentMethod = paymentMethod;
            this.status = status;
            this.transactionID = transactionID;
        }

        public PaymentBuilder copy(Payment payment) {
            this.paymentID = payment.paymentID;
            this.amount = payment.amount;
            this.paymentDate = payment.paymentDate;
            this.paymentMethod = payment.paymentMethod;
            this.status = payment.status;
            this.transactionID = payment.transactionID;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}