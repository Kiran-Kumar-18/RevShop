package com.revshop.controller;

import com.revshop.model.Order;
import com.revshop.service.IOrderService;
import com.revshop.service.OrderService;

import java.time.LocalDateTime;

public class OrderController {

    IOrderService service = new OrderService();

    public boolean create(Order o) {
        o.status = "PLACED";
        o.order_date = LocalDateTime.now();
        return service.place_order(o);
    }
}
