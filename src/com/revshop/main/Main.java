package com.revshop.main;

import java.util.Scanner;

import com.revshop.controller.CartController;
import com.revshop.controller.UserController;
import com.revshop.controller.FavoriteController;
import com.revshop.controller.ProductController;
import com.revshop.controller.CategoryController;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Controllers
        UserController userController = new UserController(sc); //  FIXED
        ProductController productController = new ProductController();
        CartController cartController = new CartController();
        FavoriteController favoriteController = new FavoriteController();
        CategoryController categoryController = new CategoryController();

        int userId = -1;

        while (true) {

            // ========== NOT LOGGED IN ==========
            if (userId == -1) {

                System.out.println("\n1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> userController.register();
                    case 2 -> userId = userController.login();
                    case 3 -> System.exit(0);
                    default -> System.out.println("Invalid choice");
                }
            }

            // ========== LOGGED IN ==========
            else {

                System.out.println("\n1. View Products");
                System.out.println("2. View Categories");
                System.out.println("3. View Products By Category");
                System.out.println("4. Add To Cart");
                System.out.println("5. Update Cart Item");
                System.out.println("6. Remove Cart Item");
                System.out.println("7. View Cart");
                System.out.println("8. Add Favorite");
                System.out.println("9. View Favorites");
                System.out.println("10. Remove Favorite");
                System.out.println("11. Logout");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> productController.showProducts();
                    case 2 -> categoryController.showAllCategories();
                    case 3 -> categoryController.showProductsOfCategory();
                    case 4 -> cartController.addItem(userId);
                    case 5 -> cartController.updateItem(userId);
                    case 6 -> cartController.removeItem(userId);
                    case 7 -> cartController.viewCart(userId);
                    case 8 -> favoriteController.addFavorite(userId);
                    case 9 -> favoriteController.viewFavorites(userId);
                    case 10 -> favoriteController.removeFavorite(userId);
                    case 11 -> {
                        userId = -1;
                        System.out.println("Logged out successfully");
                    }
                    default -> System.out.println("Invalid choice");
                }
            }
        }
    }
}
