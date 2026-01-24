package com.revshop.model;

import java.time.LocalDateTime;

public class User {
    public int user_id;
    public String name;
    public String email;
    public String password_hash;
    public String phone;
    public String role;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;
}
