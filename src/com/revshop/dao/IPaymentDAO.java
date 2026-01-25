package com.revshop.dao;

import com.revshop.model.Payment;

public interface IPaymentDAO {
    boolean addPayment(Payment payment);

    boolean savePayment(Payment payment);
}