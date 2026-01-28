package com.revshop.service;

import com.revshop.dao.IUserDAO;
import com.revshop.dao.UserDAO;
import com.revshop.model.User;

public class UserService implements IUserService {

    private IUserDAO userDAO = new UserDAO();

    @Override
    public void register(User user) {
        userDAO.register(user);
    }

    @Override
    public int login(String email, String password) {
        User user = userDAO.login(email, password);
        return user != null ? user.getUserId() : -1;
    }

    @Override
    public User viewProfile(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public void updateProfile(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void changePassword(int userId, String newPassword) {
        userDAO.changePassword(userId, newPassword);
    }
}
