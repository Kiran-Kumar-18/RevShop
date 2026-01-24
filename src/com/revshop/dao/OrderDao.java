package com.revshop.dao;

import com.revshop.model.Order;
import com.revshop.util.JDBCUtil;
import java.sql.*;

public class OrderDao {

    public boolean create_order(Order o) {
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps =
                     con.prepareStatement("insert into orders values (?,?,?,?,?,?,?)")) {

            ps.setInt(1, o.order_id);
            ps.setInt(2, o.user_id);
            ps.setInt(3, o.shipping_address_id);
            ps.setInt(4, o.billing_address_id);
            ps.setTimestamp(5, Timestamp.valueOf(o.order_date));
            ps.setDouble(6, o.total_amount);
            ps.setString(7, o.status);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
