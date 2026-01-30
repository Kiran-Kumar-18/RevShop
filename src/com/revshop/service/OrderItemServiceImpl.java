package com.revshop.service;

import com.revshop.dao.IOrderItemDAO;
import com.revshop.dao.OrderItemDAOImpl;
import com.revshop.model.OrderItem;

public class OrderItemServiceImpl implements IOrderItemService {

    private IOrderItemDAO dao;

    public OrderItemServiceImpl() {
        dao = new OrderItemDAOImpl();
    }

    @Override
    public boolean addOrderItem(OrderItem item) {
        double subtotal = item.getUnitPrice() * item.getQuantity();
        item.setSubtotal(subtotal);
        return dao.insertOrderItem(item);
    }
}
