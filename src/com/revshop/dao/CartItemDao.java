package com.revshop.dao;

import com.revshop.model.CartItem;
import com.revshop.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartItemDao {

    // ADD ITEM TO CART
    public void addItem(CartItem item) {

        String sql = """
            INSERT INTO cart_items
            (cart_item_id, cart_id, product_id, quantity)
            VALUES (cart_items_seq.NEXTVAL, ?, ?, ?)
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, item.getCartId());
            ps.setInt(2, item.getProductId());
            ps.setInt(3, item.getQuantity());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE QUANTITY
    public void updateQuantity(int cartId, int productId, int quantity) {

        String sql = """
            UPDATE cart_items
            SET quantity = ?
            WHERE cart_id = ? AND product_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, cartId);
            ps.setInt(3, productId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // REMOVE SINGLE ITEM
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
            e.printStackTrace();
        }
    }

    // GET CART ITEMS
    public List<CartItem> getCartItems(int cartId) {

        List<CartItem> list = new ArrayList<>();
        String sql = "SELECT cart_item_id, cart_id, product_id, quantity FROM cart_items WHERE cart_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem item = new CartItem();
                item.setCartItemId(rs.getInt("cart_item_id"));
                item.setCartId(rs.getInt("cart_id"));
                item.setProductId(rs.getInt("product_id"));
                item.setQuantity(rs.getInt("quantity"));

                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // CLEAR CART
    public void clearCart(int cartId) {

        String sql = "DELETE FROM cart_items WHERE cart_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean productExists(int productId) {

        String sql = "SELECT 1 FROM products WHERE product_id = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
