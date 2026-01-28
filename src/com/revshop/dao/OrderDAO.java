package com.revshop.dao;

import com.revshop.model.Order;
import com.revshop.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDAO implements IOrderDAOImpl {

    @Override
    public boolean insertOrder(Order order) {

        String sql =
                "INSERT INTO orders " +
                        "(order_id, user_id, shipping_address_id, billing_address_id, order_date, total_amount, status) " +
                        "VALUES (orders_seq.NEXTVAL, ?, ?, ?, SYSTIMESTAMP, ?, 'PLACED')";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, order.user_id);
            ps.setInt(2, order.shipping_address_id);
            ps.setInt(3, order.billing_address_id);
            ps.setDouble(4, order.total_amount);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
