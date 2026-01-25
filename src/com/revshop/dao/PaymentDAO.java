package com.revshop.dao;

import com.revshop.model.Payment;
import com.revshop.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO implements IPaymentDAO {

    @Override
    public boolean addPayment(Payment payment) {

        return false;
    }

    @Override
    public boolean savePayment(Payment payment) {
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into payments(order_id,amount,payment_method,payment_status) values(?,?,?,?)"
            );
            ps.setInt(1, payment.getOrderId());
            ps.setDouble(2, payment.getAmount());
            ps.setString(3, payment.getPaymentMethod());
            ps.setString(4, payment.getPaymentStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}