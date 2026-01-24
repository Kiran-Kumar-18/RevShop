package com.revshop.service;

import com.revshop.dao.OrderDao;
import com.revshop.model.Order;

public class OrderService {
    OrderDao dao = new OrderDao();
    public boolean place_order(Order o) {
        return dao.create_order(o);
    }
}
