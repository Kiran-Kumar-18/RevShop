package com.revshop.service;

import com.revshop.dao.*;
import com.revshop.model.User;

public class UserService implements IUserService {

    private final IUserDAO dao = new UserDAO();

    @Override
    public int login(String email, String password) {
        return dao.login(email, password);
    }

    @Override
    public boolean register(String name, String email, String password) {
        return dao.register(name, email, password);
    }

    @Override
    public User viewProfile(int userId) {
        return dao.getUserById(userId);
    }

    @Override
    public boolean updateProfile(User user) {
        return dao.updateProfile(user);
    }

    @Override
    public boolean changePassword(int userId, String newPassword) {
        return dao.changePassword(userId, newPassword);
    }
}
