package com.revshop.dao;

import com.revshop.model.Payment;
import com.revshop.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDaoImpl implements IPaymentDAO {

    @Override
    public boolean addPayment(Payment payment) {
        try (Connection conn = JDBCUtil.getConnection()) {

            String sql =
                    "INSERT INTO payments (payment_id, order_id, amount, payment_method, payment_status) " +
                            "VALUES (payment_seq.NEXTVAL, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, payment.getOrderId());
            ps.setDouble(2, payment.getAmount());
            ps.setString(3, payment.getPaymentMethod());
            ps.setString(4, payment.getPaymentStatus());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean savePayment(Payment payment) {
        return false;
    }
}