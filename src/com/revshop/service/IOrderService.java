package com.revshop.service;

import com.revshop.model.Order;

public interface IOrderService {
    boolean place_order(Order o);
}
