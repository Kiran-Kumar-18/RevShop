package com.revshop.service;

public interface IUserService {
    boolean register(String name,String email,String password);
    int login(String email,String password);
}
