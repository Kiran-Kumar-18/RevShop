package com.revshop.service;

import com.revshop.model.Order;

public interface IOrderServiceImpl {
    boolean placeOrder(Order order);
}
