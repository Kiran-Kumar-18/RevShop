package com.revshop.controller;

import java.util.Scanner;
import com.revshop.service.UserService;

public class UserController {

    private final UserService service=new UserService();
    private final Scanner sc=new Scanner(System.in);

    public int login() {
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        int userId = service.login(email, password);

        if (userId > 0) {
            System.out.println("Login successful! Welcome 🙂");
        } else {
            System.out.println("Invalid email or password ❌");
        }

        return userId;
    }


    public void register() {

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        boolean success = service.register(name, email, password);

        if (success) {
            System.out.println("Registered Successfully");
        } else {
            System.out.println("❌ Email already registered. Please login.");
        }
    }

}
