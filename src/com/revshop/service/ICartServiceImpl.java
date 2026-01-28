package com.revshop.service;

import com.revshop.model.CartItem;
import java.util.List;

public interface ICartServiceImpl {

    void addProductToCart(int cartId, int productId, int quantity);

    void updateCartItem(int cartId, int productId, int quantity);

    void removeProductFromCart(int cartId, int productId);

    List<CartItem> viewCartItems(int cartId);

    void clearCart(int cartId);
}
