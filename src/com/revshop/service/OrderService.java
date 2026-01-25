package com.revshop.service;

import com.revshop.dao.IOrderDAO;
import com.revshop.dao.OrderDAO;
import com.revshop.model.Order;
import com.revshop.model.Notification;

import java.time.LocalDateTime;

public class OrderService implements IOrderService {

    IOrderDAO dao = new OrderDAO();

    public boolean place_order(Order o) {
        boolean result = dao.create_order(o);

        if (result) {
            Notification n = new Notification();
            n.notification_id = 0;
            n.user_id = o.user_id;
            n.title = "Order Placed";
            n.message = "Your order has been placed successfully";
            n.type = "ORDER";
            n.is_read = false;
            n.created_at = LocalDateTime.now();
            dao.create_notification(n);
        }

        return result;
    }
}
