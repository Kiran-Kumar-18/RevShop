package com.revshop.controller;

import com.revshop.model.Order;
import com.revshop.service.IOrderServiceImpl;
import com.revshop.service.OrderService;

public class OrderController {

    private IOrderServiceImpl service;

    public OrderController() {
        service = new OrderService();
    }

    public boolean create(Order order) {
        return service.placeOrder(order);
    }
}
