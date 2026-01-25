package com.revshop.dao;

import com.revshop.model.Order;

public class OrderDAO implements IOrderDAO {

    @Override
    public boolean createOrder(Order order) {
        // DB logic here
        return true;
    }
}
