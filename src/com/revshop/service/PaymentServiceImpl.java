package com.revshop.service;

import com.revshop.dao.IPaymentDAO;
import com.revshop.dao.PaymentDAOImpl;
import com.revshop.model.Payment;

import java.util.List;

public class PaymentServiceImpl implements IPaymentService {

    private IPaymentDAO paymentDAO = new PaymentDAOImpl();

    public PaymentServiceImpl() throws Exception {
    }

    @Override
    public boolean processPayment(Payment payment) {

        if (payment.getOrderId() <= 0)
            throw new IllegalArgumentException("Order Id must be greater than 0");

        if (payment.getAmount() <= 0)
            throw new IllegalArgumentException("Amount must be greater than 0");

        return paymentDAO.savePayment(payment);
    }

    @Override
    public Payment viewPayment(int paymentId) {
        return paymentDAO.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> viewAllPayments() {
        return paymentDAO.getAllPayments();
    }

    @Override
    public boolean updatePaymentStatus(int paymentId, String status) {
        return paymentDAO.updatePaymentStatus(paymentId, status);
    }

    @Override
    public boolean removePayment(int paymentId) {
        return paymentDAO.deletePayment(paymentId);
    }
}
