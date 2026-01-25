package com.revshop.dao;

import com.revshop.model.User;

public interface IUserDAO {

    int login(String email, String password);

    boolean register(String name, String email, String password);

    boolean emailExists(String email);

    // ✅ ADD THESE (feature-user)
    User getUserById(int userId);

    boolean updateProfile(User user);

    boolean changePassword(int userId, String newPassword);
}
