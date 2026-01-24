package com.revshop.model;

import java.time.LocalDateTime;

public class Order {
    public int order_id;
    public int user_id;
    public int shipping_address_id;
    public int billing_address_id;
    public LocalDateTime order_date;
    public double total_amount;
    public String status;
}
