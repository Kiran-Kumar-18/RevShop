package com.revshop.service;

import com.revshop.dao.IPaymentDAO;
import com.revshop.dao.PaymentDaoImpl;
import com.revshop.model.Payment;

public class PaymentServiceImpl implements IPaymentService {

    private IPaymentDAO paymentDAO = new PaymentDaoImpl();

    @Override
    public void addPayment(Payment payment) {

    }

    @Override
    public boolean processPayment(Payment payment) {
        return paymentDAO.addPayment(payment);
    }
}