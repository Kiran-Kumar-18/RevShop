package com.revshop.service;

import com.revshop.dao.CartDAOImpl;
import com.revshop.dao.ICartDAO;
import com.revshop.model.CartItem;
import com.revshop.util.LoggerUtil;

import java.util.Collections;
import java.util.List;

public class CartServiceImpl implements ICartService {

    private ICartDAO dao = new CartDAOImpl();

    @Override
    public void addProductToCart(int userId, int productId, int quantity) {
        try {
            dao.addToCart(userId, productId, quantity);
            LoggerUtil.logInfo("Added product " + productId + " to cart for user " + userId);
        } catch (Exception e) {
            LoggerUtil.logError("Error adding to cart", e);
        }
    }

    @Override
    public List<CartItem> viewCartItems(int userId) {
        return ((CartDAOImpl) dao).getCartItems(userId); 
    }

    @Override
    public void updateCartItem(int userId, int productId, int quantity) {
        dao.updateCartItem(userId, productId, quantity);
    }

    @Override
    public void removeProductFromCart(int userId, int productId) {
        dao.removeCartItem(userId, productId);
    }

    @Override
    public void clearCart(int userId) {
        // Implementation pending in DAO or ignoring
    }
}
