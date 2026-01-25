package com.revshop.dao;

import com.revshop.model.User;

public interface IUserDAO {

    void register(User user);

    User login(String email, String password);

    User getUserById(int userId);

    void updateUser(User user);

    void changePassword(int userId, String newPassword);
}
