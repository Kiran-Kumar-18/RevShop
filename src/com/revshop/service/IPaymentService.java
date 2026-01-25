package com.revshop.service;

import com.revshop.model.Payment;

public interface IPaymentService {
    void addPayment(Payment payment);

    boolean processPayment(Payment payment);
}