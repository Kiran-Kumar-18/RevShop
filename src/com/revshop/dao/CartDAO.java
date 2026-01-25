package com.revshop.dao;

import java.sql.*;
import com.revshop.util.JDBCUtil;

public class CartDAO implements ICartDAO {
    @Override
    public void addToCart(int userId, int productId, int qty) {

        String insertSql =
                "INSERT INTO cart_items (cart_item_id, cart_id, product_id, quantity) " +
                        "VALUES (cart_items_seq.NEXTVAL, " +
                        "(SELECT cart_id FROM carts WHERE user_id=?), ?, ?)";

        try (Connection con = JDBCUtil.getConnection()) {

            if (cartItemExists(userId, productId)) {

                int currentQty = getCurrentQuantity(userId, productId);
                int newQty = currentQty + qty;

                updateCartItem(userId, productId, newQty);
            }
            else {
                try (PreparedStatement ps = con.prepareStatement(insertSql)) {
                    ps.setInt(1, userId);
                    ps.setInt(2, productId);
                    ps.setInt(3, qty);
                    ps.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean cartItemExists(int userId, int productId) {

        String sql =
                "SELECT 1 FROM cart_items " +
                        "WHERE cart_id=(SELECT cart_id FROM carts WHERE user_id=?) " +
                        "AND product_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, productId);
            return ps.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getCurrentQuantity(int userId, int productId) {

        String sql =
                "SELECT quantity FROM cart_items " +
                        "WHERE cart_id=(SELECT cart_id FROM carts WHERE user_id=?) " +
                        "AND product_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateCartItem(int userId, int productId, int qty) {

        String sql =
                "UPDATE cart_items SET quantity=? " +
                        "WHERE cart_id=(SELECT cart_id FROM carts WHERE user_id=?) " +
                        "AND product_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, qty);
            ps.setInt(2, userId);
            ps.setInt(3, productId);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int removeCartItem(int userId, int productId) {

        String sql =
                "DELETE FROM cart_items " +
                        "WHERE cart_id=(SELECT cart_id FROM carts WHERE user_id=?) " +
                        "AND product_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, productId);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void viewCart(int userId) {

        String sql =
                "SELECT p.product_id, p.name, p.price, c.quantity " +
                        "FROM cart_items c " +
                        "JOIN products p ON c.product_id = p.product_id " +
                        "WHERE c.cart_id=(SELECT cart_id FROM carts WHERE user_id=?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n🛒 Your Cart:");
            boolean empty = true;

            while (rs.next()) {
                empty = false;
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("name") + " | ₹" +
                                rs.getDouble("price") + " | Qty: " +
                                rs.getInt("quantity")
                );
            }

            if (empty) {
                System.out.println("Cart is empty.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
