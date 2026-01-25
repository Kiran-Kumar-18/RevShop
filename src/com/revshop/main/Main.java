package com.revshop.main;

import java.util.Scanner;
import com.revshop.controller.CartController;
import com.revshop.controller.ProductController;
import com.revshop.controller.UserController;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserController userController = new UserController();
        ProductController productController = new ProductController();
        CartController cartController = new CartController();

        int userId = -1; // not logged in

        while (true) {

            //  NOT LOGGED IN
            if (userId == -1) {

                System.out.println("\n1.Register");
                System.out.println("2.Login");
                System.out.println("3.Exit");

                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1 -> userController.register();
                    case 2 -> userId = userController.login();
                    case 3 -> System.exit(0);
                    default -> System.out.println(" Invalid choice");
                }
            }

            //  LOGGED IN
            else {

                System.out.println("\n1.View Products");
                System.out.println("2.Add To Cart");
                System.out.println("3.Update Cart Item");
                System.out.println("4.Remove Cart Item");
                System.out.println("5.View Cart");
                System.out.println("6.Logout");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> productController.showProducts();
                    case 2 -> cartController.addItem(userId);
                    case 3 -> cartController.updateItem(userId);
                    case 4 -> cartController.removeItem(userId);
                    case 5 -> cartController.viewCart(userId);
                    case 6 -> {
                        userId = -1;
                        System.out.println("Logged out successfully ");
                    }
                    default -> System.out.println(" Invalid choice");
                }
            }
        }
    }
}
