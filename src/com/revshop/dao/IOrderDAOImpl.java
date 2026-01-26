package com.revshop.dao;

import com.revshop.model.Order;

public interface IOrderDAO {
    boolean createOrder(Order order);
}
