package com.revshop.service;

import com.revshop.dao.IUserDAO;
import com.revshop.dao.UserDAO;

public class UserService {

    private final IUserDAO userDAO = new UserDAO();

    //  LOGIN METHOD (THIS WAS MISSING)
    public int login(String email, String password) {
        return userDAO.login(email, password);
    }

    // REGISTER METHOD (YOU ALREADY USE THIS)
    public boolean register(String name, String email, String password) {
        return userDAO.register(name, email, password);
    }
}
