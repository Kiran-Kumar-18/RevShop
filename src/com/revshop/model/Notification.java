package com.revshop.model;

import java.time.LocalDateTime;

public class Notification {
    public int notification_id;
    public int user_id;
    public String message;
    public boolean is_read;
    public LocalDateTime created_at;
}
