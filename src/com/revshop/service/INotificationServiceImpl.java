package com.revshop.service;

import java.util.List;
import com.revshop.model.Notification;

public interface INotificationServiceImpl {

    void notifyOrderPlaced(int userId, int orderId);

    List<Notification> viewNotifications(int userId);

    void readNotification(int notificationId);
}
