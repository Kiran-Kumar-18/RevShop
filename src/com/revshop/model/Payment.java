package com.revshop.model;

import java.time.LocalDateTime;

public class Payment {
    public int payment_id;
    public int order_id;
    public String method;
    public double amount;
    public String payment_status;
    public LocalDateTime paid_at;
}
