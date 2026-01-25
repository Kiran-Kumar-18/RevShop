package com.revshop.service;

import com.revshop.model.User;

public interface IUserService {

    void register(User user);

    int login(String email, String password);

    User viewProfile(int userId);

    void updateProfile(User user);

    void changePassword(int userId, String newPassword);
}
