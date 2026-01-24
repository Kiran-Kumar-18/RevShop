package com.revshop.dao;

import com.revshop.model.Cart;
import com.revshop.util.JDBCUtil;

import java.sql.*;

public class CartDao {

    public Cart getOrCreateCart(int user_id) {

        String selectSql = "SELECT cart_id, user_id FROM carts WHERE user_id = ?";
        String insertSql = """
INSERT INTO cart_items
(cart_item_id, cart_id, product_id, quantity)
VALUES (cart_item_seq.NEXTVAL, ?, ?, ?)
""";


        try (Connection con = JDBCUtil.getConnection()) {

            // 1. Check existing cart
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cart c = new Cart();
                c.cart_id = rs.getInt("cart_id");
                c.user_id = rs.getInt("user_id");
                return c;
            }

            // 2. Create new cart (Oracle-safe)
            CallableStatement cs = con.prepareCall(insertSql);
            cs.setInt(1, user_id);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();

            Cart c = new Cart();
            c.cart_id = cs.getInt(2);
            c.user_id = user_id;
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Cart getCartByUserId(int userId) {
        String sql = "SELECT cart_id, user_id FROM carts WHERE user_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cart cart = new Cart();
                cart.cart_id = rs.getInt("cart_id");
                cart.user_id = rs.getInt("user_id");
                return cart;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
