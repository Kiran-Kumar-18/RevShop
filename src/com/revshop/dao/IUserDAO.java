package com.revshop.dao;

public interface IUserDAO {


    boolean emailExists(String email);


        int login(String email, String password);
        boolean register(String name, String email, String password);


}
