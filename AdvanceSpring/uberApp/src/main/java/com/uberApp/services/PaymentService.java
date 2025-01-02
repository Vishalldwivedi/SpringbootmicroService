package com.uberApp.services;

import com.uberApp.entities.Payment;
import com.uberApp.entities.Ride;
import com.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
