package com.revshop.controller;

import com.revshop.model.Order;
import com.revshop.service.OrderService;

public class OrderController {
    OrderService service = new OrderService();
    public boolean create(Order o) {
        return service.place_order(o);
    }
}
