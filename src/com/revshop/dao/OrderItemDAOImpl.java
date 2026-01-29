package com.revshop.dao;

import com.revshop.model.OrderItem;
import com.revshop.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderItemDAOImpl implements IOrderItemDAO {

    @Override
    public boolean insertOrderItem(OrderItem item) {

        String sql =
                "INSERT INTO order_items " +
                        "(order_id, product_id, seller_id, unit_price, quantity, subtotal) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection()) {

            if (con == null) return false;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item.order_id);
            ps.setInt(2, item.product_id);
            ps.setInt(3, item.seller_id);
            ps.setDouble(4, item.unit_price);
            ps.setInt(5, item.quantity);
            ps.setDouble(6, item.subtotal);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
