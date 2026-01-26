package com.revshop.dao;

import com.revshop.model.Payment;
import com.revshop.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaymentDAO implements IPaymentDAOImpl {

    private Connection connection = JDBCUtil.getConnection();

    public PaymentDAO() throws Exception {
    }

    @Override
    public boolean savePayment(Payment payment) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select payments_seq.nextval from dual");

            if (rs.next()) {
                payment.setPaymentId(rs.getInt(1));
            }

            String sql =
                    "insert into payments(payment_id,order_id,amount,payment_method,payment_status) " +
                            "values(?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, payment.getPaymentId());
            ps.setInt(2, payment.getOrderId());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getPaymentStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
