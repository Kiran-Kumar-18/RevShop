package com.revshop.dao;

import com.revshop.model.CartItem;
import com.revshop.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartItemDao {

    // Add item to cart
    public void addItem(int cartId, int productId, int quantity) {

        String sql = """
            INSERT INTO cart_items
            (cart_item_id, cart_id, product_id, quantity)
            VALUES (cart_item_seq.NEXTVAL, ?, ?, ?)
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to add item to cart", e);
        }
    }

    // ✅ THIS METHOD WAS MISSING
    public void removeItem(int cartId, int productId) {

        String sql = """
            DELETE FROM cart_items
            WHERE cart_id = ? AND product_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);
            ps.setInt(2, productId);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to remove item from cart", e);
        }
    }

    // Get all items in a cart
    public List<CartItem> getCartItems(int cartId) {

        List<CartItem> items = new ArrayList<>();

        String sql = """
            SELECT cart_item_id, cart_id, product_id, quantity
            FROM cart_items
            WHERE cart_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem item = new CartItem();
                item.cart_item_id = rs.getInt("cart_item_id");
                item.cart_id = rs.getInt("cart_id");
                item.product_id = rs.getInt("product_id");
                item.quantity = rs.getInt("quantity");
                items.add(item);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch cart items", e);
        }

        return items;
    }
}
