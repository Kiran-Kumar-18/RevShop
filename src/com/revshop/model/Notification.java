package com.revshop.model;

import java.util.Date;

public class Notification {

    private int notificationId;
    private int userId;
    private String title;
    private String message;
    private String type;
    private boolean read;
    private Date createdAt;

    public int getNotificationId() { return notificationId; }
    public int getUserId() { return userId; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getType() { return type; }
    public boolean isRead() { return read; }
    public Date getCreatedAt() { return createdAt; }

    public void setNotificationId(int notificationId) { this.notificationId = notificationId; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setTitle(String title) { this.title = title; }
    public void setMessage(String message) { this.message = message; }
    public void setType(String type) { this.type = type; }
    public void setRead(boolean read) { this.read = read; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
