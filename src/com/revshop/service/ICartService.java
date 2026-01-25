package com.revshop.service;

public interface ICartService {

    boolean addToCart(int userId, int productId, int qty);

    boolean updateCartItem(int userId, int productId, int qty);

    boolean removeCartItem(int userId, int productId);
    void viewCart(int userId);
}
