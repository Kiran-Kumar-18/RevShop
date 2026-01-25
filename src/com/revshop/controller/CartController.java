package com.revshop.controller;

import java.util.List;
import java.util.Scanner;
import com.revshop.service.*;

public class CartController {

    private final ICartService service = new CartService();
    private final ProductController productController = new ProductController();
    private final Scanner sc = new Scanner(System.in);
    public void addItem(int userId) {

        List<Integer> productIds = productController.showProductsWithNumbers();

        if (productIds.isEmpty()) return;

        System.out.print("Choose Product Number: ");
        int choice = sc.nextInt();

        if (choice <= 0 || choice > productIds.size()) {
            System.out.println(" Invalid choice");
            return;
        }

        int productId = productIds.get(choice - 1);

        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println(" Quantity must be positive");
            return;
        }

        service.addToCart(userId, productId, qty);
        System.out.println(" Cart updated successfully");
        viewCart(userId);
    }



    public void updateItem(int userId) {

        // Always show cart first
        viewCart(userId);

        System.out.print("Enter Product ID to update (number only): ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a numeric Product ID.");
            sc.nextLine(); // clear bad input
            return;
        }
        int pid = sc.nextInt();

        System.out.print("Enter new quantity: ");

        if (!sc.hasNextInt()) {
            System.out.println(" Invalid quantity. Please enter a number.");
            sc.nextLine();
            return;
        }
        int qty = sc.nextInt();

        try {
            boolean updated = service.updateCartItem(userId, pid, qty);

            if (updated) {
                System.out.println(" Cart updated successfully");
            } else {
                System.out.println("Item not found in cart");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("  " + e.getMessage());
        }

        // Refresh cart view
        viewCart(userId);
    }


    public void removeItem(int userId) {

        viewCart(userId);

        System.out.print("Product ID to remove: ");
        int pid = sc.nextInt();

        System.out.println(
                service.removeCartItem(userId, pid)
                        ? " Item removed"
                        : " Item not found"
        );

        viewCart(userId);
    }

    public void viewCart(int userId) {
        service.viewCart(userId);
    }
}
