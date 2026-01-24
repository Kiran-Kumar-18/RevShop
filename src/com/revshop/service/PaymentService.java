package com.revshop.service;

import com.revshop.dao.PaymentDao;
import com.revshop.model.Payment;

public class PaymentService {
    PaymentDao dao = new PaymentDao();
    public boolean pay(Payment p) {
        return dao.make_payment(p);
    }
}
