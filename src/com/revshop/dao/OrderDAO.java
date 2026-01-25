package com.revshop.dao;

import com.revshop.model.Order;
import com.revshop.model.Notification;
import com.revshop.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class OrderDAO implements IOrderDAO {

    public boolean create_order(Order o) {
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "insert into orders (order_id, user_id, shipping_address_id, billing_address_id, order_date, total_amount, status) values (?,?,?,?,?,?,?)")) {

            ps.setInt(1, o.order_id);
            ps.setInt(2, o.user_id);
            ps.setInt(3, o.shipping_address_id);
            ps.setInt(4, o.billing_address_id);
            ps.setTimestamp(5, Timestamp.valueOf(o.order_date));
            ps.setDouble(6, o.total_amount);
            ps.setString(7, o.status);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean create_notification(Notification n) {
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps =
                     con.prepareStatement("insert into notifications values (?,?,?,?,?,?,?)")) {

            ps.setInt(1, n.notification_id);
            ps.setInt(2, n.user_id);
            ps.setString(3, n.title);
            ps.setString(4, n.message);
            ps.setString(5, n.type);
            ps.setBoolean(6, n.is_read);
            ps.setTimestamp(7, Timestamp.valueOf(n.created_at));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
