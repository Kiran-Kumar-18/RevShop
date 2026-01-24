package com.revshop.model;

import java.time.LocalDateTime;

public class Product {
    public int product_id;
    public int seller_id;
    public int category_id;
    public String name;
    public String description;
    public double price;
    public double mrp;
    public double discount_price;
    public int stock_quantity;
    public int stock_threshold;
    public boolean is_active;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;
}
