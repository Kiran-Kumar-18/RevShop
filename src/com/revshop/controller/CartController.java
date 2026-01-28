package com.revshop.controller;

import com.revshop.model.CartItem;
import com.revshop.service.CartService;
import com.revshop.service.ICartServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CartController {

    public static void main(String[] args) {

        ICartServiceImpl service = new CartService();
        Scanner sc = new Scanner(System.in);

        int cartId = 1; // example cart id

        while (true) {
            System.out.println("\n--- CART MENU ---");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Update Quantity");
            System.out.println("4. Remove Product");
            System.out.println("5. Clear Cart");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    service.addProductToCart(cartId, productId, quantity);
                    System.out.println("✅ Item added to cart");
                    break;

                case 2:
                    List<CartItem> items = service.viewCartItems(cartId);

                    if (items.isEmpty()) {
                        System.out.println("Cart is empty");
                    } else {
                        for (CartItem item : items) {
                            System.out.println(
                                    "Product ID: " + item.getProductId() +
                                            " | Quantity: " + item.getQuantity()
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    productId = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    quantity = sc.nextInt();

                    service.updateCartItem(cartId, productId, quantity);
                    System.out.println("✅ Quantity updated");
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    productId = sc.nextInt();

                    service.removeProductFromCart(cartId, productId);
                    System.out.println("✅ Product removed from cart");
                    break;

                case 5:
                    service.clearCart(cartId);
                    System.out.println("✅ Cart cleared");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
