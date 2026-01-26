package com.revshop.service;

import com.revshop.model.Payment;

public interface IPaymentServiceImpl {

    boolean processPayment(Payment payment);
}
