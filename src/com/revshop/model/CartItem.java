package com.revshop.model;

import java.time.LocalDateTime;

public class CartItem {
    public int cart_item_id;
    public int cart_id;
    public int product_id;
    public int quantity;
    public LocalDateTime added_at;
}
