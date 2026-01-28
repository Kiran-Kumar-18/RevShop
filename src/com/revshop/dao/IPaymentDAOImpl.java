package com.revshop.dao;

import com.revshop.model.Payment;

public interface IPaymentDAOImpl {

    boolean savePayment(Payment payment);
}
