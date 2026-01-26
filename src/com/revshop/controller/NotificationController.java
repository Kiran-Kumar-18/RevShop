package com.revshop.controller;

import com.revshop.model.Notification;
import com.revshop.service.NotificationService;

import java.util.List;

public class NotificationController {

    private NotificationService service;

    // Constructor
    public NotificationController() {
        service = new NotificationService();
    }

    // Show notifications for a user
    public void showNotifications(int userId) {

        List<Notification> list = service.viewNotifications(userId);

        System.out.println("---- Notifications ----");

        if (list.isEmpty()) {
            System.out.println("No notifications found.");
            return;
        }

        for (Notification n : list) {
            System.out.println(
                    n.getNotificationId() + " | " +
                            n.getTitle() + " | " +
                            n.getMessage() + " | Read: " + n.isRead()
            );
        }
    }

    // Mark notification as read
    public void markAsRead(int notificationId) {
        service.readNotification(notificationId);
        System.out.println("Notification marked as read.");
    }
}
