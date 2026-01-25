package com.revshop.dao;

import java.sql.*;
import com.revshop.util.JDBCUtil;

public class UserDAO implements IUserDAO {

    @Override
    public int login(String email, String password) {

        String sql = "SELECT user_id FROM users WHERE email=? AND password_hash=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean register(String name, String email, String password) {

        String checkSql = "SELECT 1 FROM users WHERE email=?";
        String insertSql =
                "INSERT INTO users (user_id, name, email, password_hash) " +
                        "VALUES (users_seq.NEXTVAL, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection()) {

            // check duplicate email
            PreparedStatement check = con.prepareStatement(checkSql);
            check.setString(1, email);
            if (check.executeQuery().next()) return false;

            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean emailExists(String email) {

        String sql = "SELECT 1 FROM users WHERE email = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
