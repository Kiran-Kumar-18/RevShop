package com.revshop.dao;

import java.util.List;
import com.revshop.model.Notification;

public interface INotificationDAOImpl {

    void addNotification(Notification notification);
    List<Notification> getNotificationsByUser(int userId);
    void markAsRead(int notificationId);
}
