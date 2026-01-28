package com.revshop.service;

import com.revshop.dao.IPaymentDAOImpl;
import com.revshop.dao.PaymentDAO;
import com.revshop.model.Payment;

public class PaymentService implements IPaymentServiceImpl {

    private IPaymentDAOImpl paymentDAO = new PaymentDAO();

    public PaymentService() throws Exception {
    }

    @Override
    public boolean processPayment(Payment payment) {
        return paymentDAO.savePayment(payment);
    }
}
