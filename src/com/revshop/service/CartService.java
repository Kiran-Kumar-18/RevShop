package com.revshop.service;

import com.revshop.dao.CartDao;
import com.revshop.dao.CartItemDao;
import com.revshop.model.Cart;
import com.revshop.model.CartItem;

import java.util.Collections;
import java.util.List;

public class CartService {

    private final CartDao cartDao;
    private final CartItemDao itemDao;

    public CartService() {
        this.cartDao = new CartDao();
        this.itemDao = new CartItemDao();
    }

    // Create cart if not exists, then add item
   public void addToCart(int userId, int productId, int quantity) {

        Cart cart = cartDao.getOrCreateCart(userId);
        if (cart == null) {
            throw new RuntimeException("Cart could not be created. Check database setup.");
        }

        itemDao.addItem(cart.cart_id, productId, quantity);
    }

    // Remove item ONLY if cart exists
    public void removeFromCart(int userId, int productId) {

        Cart cart = cartDao.getCartByUserId(userId);
        if (cart == null) {
            throw new RuntimeException("Cart does not exist for user");
        }

        itemDao.removeItem(cart.cart_id, productId);
    }

    // View cart items safely
    public List<CartItem> viewCart(int userId) {

        Cart cart = cartDao.getCartByUserId(userId);
        if (cart == null) {
            return Collections.emptyList();
        }

        return itemDao.getCartItems(cart.cart_id);
    }
}
