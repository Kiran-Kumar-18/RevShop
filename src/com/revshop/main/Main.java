package com.revshop.main;

import java.util.Scanner;

import com.revshop.controller.CartController;
import com.revshop.controller.FavoriteController;
import com.revshop.controller.ProductController;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProductController productController = new ProductController();
        CartController cartController = new CartController();
        FavoriteController favoriteController = new FavoriteController();

        int userId = 1; // TEMP: assume logged in user

        while (true) {

            System.out.println("\n=== RevShop Menu ===");
            System.out.println("1. View Products");
            System.out.println("2. Add To Cart");
            System.out.println("3. Update Cart Item");
            System.out.println("4. Remove Cart Item");
            System.out.println("5. View Cart");
            System.out.println("6. Add to Favorite");
            System.out.println("7. View Favorites");
            System.out.println("8. Remove Favorite");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1 -> productController.showProducts();
                case 2 -> cartController.addItem(userId);
                case 3 -> cartController.updateItem(userId);
                case 4 -> cartController.removeItem(userId);
                case 5 -> cartController.viewCart(userId);

                case 6 -> favoriteController.addFavorite(userId);
                case 7 -> favoriteController.viewFavorites(userId);
                case 8 -> favoriteController.removeFavorite(userId);

                case 9 -> {
                    System.out.println("Exiting RevShop");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
