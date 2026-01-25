package com.revshop.controller;

import com.revshop.model.CartItem;
import com.revshop.service.CartService;

import java.util.List;

public class CartController {

    private final CartService cartService;

    public CartController() {
        this.cartService = new CartService();
    }

    // Add product to cart
    public void addProduct(int userId, int productId, int quantity) {

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero");
            return;
        }

        try {
            cartService.addToCart(userId, productId, quantity);
            System.out.println("Product added to cart successfully");
        } catch (Exception e) {
            System.out.println("Failed to add product to cart: " + e.getMessage());
        }
    }
    // Remove product from cart
    public void removeProduct(int userId, int productId) {
        try {
            cartService.removeFromCart(userId, productId);
            System.out.println("Product removed from cart successfully");
        } catch (Exception e) {
            System.out.println("Failed to remove product from cart: " + e.getMessage());
        }
    }

    // View cart items
    public void showCart(int userId) {

        List<CartItem> items = cartService.viewCart(userId);

        if (items == null || items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        System.out.println("------ CART ITEMS ------");
        for (CartItem item : items) {
            System.out.println(
                    "Product ID: " + item.product_id +
                            " | Quantity: " + item.quantity
            );
        }
        System.out.println("------------------------");
    }
}
