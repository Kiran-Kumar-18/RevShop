package com.revshop.controller;

import java.util.Scanner;

import com.revshop.model.User;
import com.revshop.service.IUserService;
import com.revshop.service.UserService;

public class UserController {

    private final IUserService service;
    private final Scanner sc;

    // Scanner comes from Main (single Scanner rule)
    public UserController(Scanner sc) {
        this.sc = sc;
        this.service = new UserService();
    }

    // ========== LOGIN ==========
    public int login() {

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        int userId = service.login(email, password);

        if (userId > 0) {
            System.out.println("Login successful! Welcome ");
        } else {
            System.out.println("Invalid email or password ");
        }

        return userId;
    }

    // ========== REGISTER ==========
    public void register() {

        User user = new User();

        System.out.print("Name: ");
        user.setName(sc.nextLine());

        System.out.print("Email: ");
        user.setEmail(sc.nextLine());

        System.out.print("Password: ");
        user.setPassword(sc.nextLine());

        System.out.print("Phone: ");
        user.setPhone(sc.nextLine());

        service.register(user);

        System.out.println("Registered successfully! Please login ");
    }
}
