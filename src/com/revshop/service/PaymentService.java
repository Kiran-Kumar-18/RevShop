package com.revshop.service;

import com.revshop.dao.IPaymentDAO;
import com.revshop.dao.PaymentDAO;
import com.revshop.model.Payment;

public class PaymentService implements IPaymentService {

    private IPaymentDAO paymentDAO = new PaymentDAO();

    @Override
    public void addPayment(Payment payment) {

    }

    @Override
    public boolean processPayment(Payment payment) {
        return paymentDAO.savePayment(payment);
    }
}