package com.revshop.controller;

import com.revshop.model.Payment;
import com.revshop.service.PaymentService;

public class PaymentController {
    PaymentService service = new PaymentService();
    public boolean pay(Payment p) {
        return service.pay(p);
    }
}
