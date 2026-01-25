package com.revshop.dao;

import com.revshop.model.Order;
import com.revshop.model.Notification;

public interface IOrderDAO {
    boolean create_order(Order o);
    boolean create_notification(Notification n);
}
