package com.revshop.service;

import com.revshop.dao.*;

public class CartService implements ICartService {

    private final ICartDAO cartDAO = new CartDAO();
    private final IProductDAO productDAO = new ProductDAO();

    @Override
    public boolean addToCart(int userId, int productId, int qty) {

        if (!productDAO.productExists(productId))
            return false;

        if (qty <= 0)
            throw new IllegalArgumentException("Quantity must be > 0");

        cartDAO.addToCart(userId, productId, qty);
        return true;
    }


    @Override
    public boolean updateCartItem(int userId, int productId, int qty) {

        if (qty <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        if (!cartDAO.cartItemExists(userId, productId)) return false;

        return cartDAO.updateCartItem(userId, productId, qty) > 0;
    }

    @Override
    public boolean removeCartItem(int userId, int productId) {

        if (!cartDAO.cartItemExists(userId, productId)) return false;
        return cartDAO.removeCartItem(userId, productId) > 0;
    }

    @Override
    public void viewCart(int userId) {
        cartDAO.viewCart(userId);
    }
}
