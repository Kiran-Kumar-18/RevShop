package com.revshop.service;

import com.revshop.model.User;

public interface IUserService {

    int login(String email, String password);

    boolean register(String name, String email, String password);

    User viewProfile(int userId);

    boolean updateProfile(User user);

    boolean changePassword(int userId, String newPassword);
}
