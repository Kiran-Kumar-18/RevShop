package com.revshop.controller;

import java.util.Scanner;

import com.revshop.model.User;
import com.revshop.service.UserService;

public class UserController {

    private final UserService service = new UserService();
    private final Scanner sc = new Scanner(System.in);

    // ✅ LOGIN
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

    // ✅ REGISTER
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

    // =========================
    // 🔽 FEATURE–USER METHODS
    // =========================

    // ✅ VIEW PROFILE
    public void viewProfile(int userId) {

        User u = service.viewProfile(userId);

        if (u == null) {
            System.out.println("User not found ❌");
            return;
        }

        System.out.println("\n--- USER PROFILE ---");
        System.out.println("Name  : " + u.getName());
        System.out.println("Email : " + u.getEmail());
        System.out.println("Phone : " + u.getPhone());
        System.out.println("Role  : " + u.getRole());
    }

    // ✅ UPDATE PROFILE
    public void updateProfile(int userId) {

        sc.nextLine(); // clear buffer

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new phone: ");
        String phone = sc.nextLine();

        User u = new User();
        u.setUserId(userId);
        u.setName(name);
        u.setPhone(phone);

        System.out.println(
                service.updateProfile(u)
                        ? "Profile updated successfully ✅"
                        : "Profile update failed ❌"
        );
    }

    // ✅ CHANGE PASSWORD
    public void changePassword(int userId) {

        sc.nextLine(); // clear buffer

        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine();

        System.out.println(
                service.changePassword(userId, newPassword)
                        ? "Password changed successfully ✅"
                        : "Password change failed ❌"
        );
    }
}
