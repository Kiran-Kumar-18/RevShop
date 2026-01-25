package com.revshop.main;

<<<<<<< HEAD
import com.revshop.controller.CartController;
import java.util.*;
=======
import java.util.Scanner;

import com.revshop.controller.CartController;
import com.revshop.controller.ProductController;
import com.revshop.controller.UserController;
import com.revshop.controller.FavoriteController;
>>>>>>> de37823 (feature-user: login, profile, password change)

public class Main {

    public static void main(String[] args) {

        CartController cart = new CartController();

<<<<<<< HEAD
        int user_id = 1;
=======
        UserController userController = new UserController();
        ProductController productController = new ProductController();
        CartController cartController = new CartController();
        FavoriteController favoriteController = new FavoriteController();
>>>>>>> de37823 (feature-user: login, profile, password change)

        cart.addProduct(user_id, 101, 2);
        cart.addProduct(user_id, 102, 1);
        cart.showCart(user_id);

<<<<<<< HEAD
        cart.removeProduct(user_id, 101);
        cart.showCart(user_id);
=======
        while (true) {

            // NOT LOGGED IN
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

            // LOGGED IN
            else {

                System.out.println("\n1.View Products");
                System.out.println("2.Add To Cart");
                System.out.println("3.Update Cart Item");
                System.out.println("4.Remove Cart Item");
                System.out.println("5.View Cart");
                System.out.println("6.Logout");
                System.out.println("7.Add to Favorite");
                System.out.println("8.View Favorites");
                System.out.println("9.Remove Favorite");
                System.out.println("10.View Profile");
                System.out.println("11.Update Profile");
                System.out.println("12.Change Password");


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
                    case 7 -> favoriteController.addFavorite(userId);
                    case 8 -> favoriteController.viewFavorites(userId);
                    case 9 -> favoriteController.removeFavorite(userId);
                    case 10 -> userController.viewProfile(userId);
                    case 11 -> userController.updateProfile(userId);
                    case 12 -> userController.changePassword(userId);

                    default -> System.out.println(" Invalid choice");
                }
            }
        }
>>>>>>> de37823 (feature-user: login, profile, password change)
    }
}
