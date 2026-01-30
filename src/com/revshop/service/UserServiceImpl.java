package com.revshop.service;

import com.revshop.dao.IUserDAO;
import com.revshop.dao.UserDAOImpl;
import com.revshop.model.User;
import com.revshop.util.LoggerUtil;

public class UserServiceImpl implements IUserService {

    private IUserDAO userDAO = new UserDAOImpl();

    @Override
    public User register(User user) {
        try {
            int id = userDAO.register(user);
            user.setUserId(id);
            LoggerUtil.logInfo("User registered successfully: " + user.getEmail());
            return user;
        } catch (Exception e) {
            LoggerUtil.logError("Error registering user: " + user.getEmail(), e);
            return null;
        }
    }

    @Override
    public User login(String email, String password) {
        try {
            User user = userDAO.login(email, password);
            if (user != null) {
                LoggerUtil.logInfo("User logged in: " + email);
            } else {
                LoggerUtil.logWarning("Failed login attempt: " + email);
            }
            return user;
        } catch (Exception e) {
            LoggerUtil.logError("Error during login: " + email, e);
            return null;
        }
    }

    @Override
    public User viewProfile(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public void updateProfile(User user) {
        userDAO.updateUser(user);
    }

    // CHANGE PASSWORD (LOGGED IN USER)
    @Override
    public boolean changePassword(int userId, String oldPassword, String newPassword) {

        boolean valid = userDAO.validatePassword(userId, oldPassword);
        if (!valid) {
            return false;
        }

        userDAO.changePassword(userId, newPassword);
        return true;
    }

    // FORGOT PASSWORD
    @Override
    public boolean forgotPassword(String email, String newPassword) {
        return userDAO.updatePasswordByEmail(email, newPassword);
    }
}
