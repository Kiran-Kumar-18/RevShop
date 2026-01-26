package com.revshop.service;

import com.revshop.dao.IOrderDAOImpl;
import com.revshop.dao.OrderDAO;
import com.revshop.model.Order;

public class OrderService implements IOrderServiceImpl {

    private IOrderDAOImpl orderDAO;

    public OrderService() {
        orderDAO = new OrderDAO(); //  valid now
    }

    @Override
    public boolean placeOrder(Order order) {
        return orderDAO.insertOrder(order);
    }
}
