package com.revshop.service;

import com.revshop.dao.CartItemDao;
import com.revshop.model.CartItem;

import java.util.List;

public class CartService implements ICartServiceImpl {

    private CartItemDao cartItemDao = new CartItemDao();

    @Override
    public void addProductToCart(int cartId, int productId, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        CartItem item = new CartItem();
        item.setCartId(cartId);
        item.setProductId(productId);
        item.setQuantity(quantity);

        cartItemDao.addItem(item);
    }

    @Override
    public void updateCartItem(int cartId, int productId, int quantity) {
        cartItemDao.updateQuantity(cartId, productId, quantity);
    }

    @Override
    public void removeProductFromCart(int cartId, int productId) {
        cartItemDao.removeItem(cartId, productId);
    }

    @Override
    public List<CartItem> viewCartItems(int cartId) {
        return cartItemDao.getCartItems(cartId);
    }

    @Override
    public void clearCart(int cartId) {
        cartItemDao.clearCart(cartId);
    }
}
