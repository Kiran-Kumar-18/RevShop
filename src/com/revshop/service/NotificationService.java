package com.revshop.service;

import com.revshop.dao.INotificationDAOImpl;
import com.revshop.dao.NotificationDAO;
import com.revshop.model.Notification;

import java.util.List;

public class NotificationService implements INotificationServiceImpl {

    private INotificationDAOImpl dao = new NotificationDAO();

    @Override
    public void notifyOrderPlaced(int userId, int orderId) {

        Notification n = new Notification();
        n.setUserId(userId);
        n.setTitle("Order Placed");
        n.setMessage("Your order #" + orderId + " placed successfully");
        n.setType("ORDER");

        dao.addNotification(n);
    }

    @Override
    public List<Notification> viewNotifications(int userId) {
        return dao.getNotificationsByUser(userId);
    }

    @Override
    public void readNotification(int notificationId) {
        dao.markAsRead(notificationId);
    }
}
