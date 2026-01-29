package com.revshop.controller;

import java.util.Scanner;

import com.revshop.service.IPasswordRecoveryServiceImpl;
import com.revshop.service.PasswordRecoveryService;

public class PasswordRecoveryController {

    private final IPasswordRecoveryServiceImpl service =
            new PasswordRecoveryService();

    private final Scanner sc = new Scanner(System.in);

    public void startPasswordRecovery() {

        System.out.println("\n=== Forgot Password ===");

        System.out.print("Enter registered email: ");
        String email = sc.nextLine();

        String question = service.getSecurityQuestion(email);

        if (question == null) {
            System.out.println("Email not found or recovery not set.");
            return;
        }

        System.out.println("\nSecurity Question:");
        System.out.println(question);

        System.out.print("Enter your answer: ");
        String answer = sc.nextLine();

        boolean valid = service.validateAnswer(email, answer);

        if (valid) {
            System.out.println("Answer verified.");

            System.out.print("Enter new password: ");
            String newPassword = sc.nextLine();

            System.out.print("Confirm new password: ");
            String confirmPassword = sc.nextLine();

            if (!newPassword.equals(confirmPassword)) {
                System.out.println("Passwords do not match.");
                return;
            }

            boolean reset = service.resetPassword(email, newPassword);

            if (reset) {
                System.out.println("Password reset successful.");
            } else {
                System.out.println("Password reset failed.");
            }
        }

    }}
