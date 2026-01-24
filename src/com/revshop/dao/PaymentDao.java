package com.revshop.dao;

import com.revshop.model.Payment;
import com.revshop.util.JDBCUtil;
import java.sql.*;

public class PaymentDao {

    public boolean make_payment(Payment p) {
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps =
                     con.prepareStatement("insert into payments values (?,?,?,?,?,?)")) {

            ps.setInt(1, p.payment_id);
            ps.setInt(2, p.order_id);
            ps.setString(3, p.method);
            ps.setDouble(4, p.amount);
            ps.setString(5, p.payment_status);
            ps.setTimestamp(6, Timestamp.valueOf(p.paid_at));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
