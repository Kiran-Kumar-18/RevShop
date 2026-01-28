package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revshop.model.User;
import com.revshop.util.JDBCUtil;

public class UserDAO implements IUserDAO {

    // ================= REGISTER =================
    @Override
    public void register(User user) {

        String sql =
                "INSERT INTO users (name, email, password_hash, phone) VALUES (?, ?, ?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword()); // later hash
            ps.setString(4, user.getPhone());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= LOGIN =================
    @Override
    public User login(String email, String password) {

        String sql =
                "SELECT * FROM users WHERE email = ? AND password_hash = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // ================= GET USER BY ID =================
    @Override
    public User getUserById(int userId) {

        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // ================= UPDATE PROFILE =================
    @Override
    public void updateUser(User user) {

        String sql =
                "UPDATE users SET name = ?, phone = ?, updated_at = SYSDATE WHERE user_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setInt(3, user.getUserId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= CHANGE PASSWORD =================
    @Override
    public void changePassword(int userId, String newPassword) {

        String sql =
                "UPDATE users SET password_hash = ?, updated_at = SYSDATE WHERE user_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPassword); // later hash
            ps.setInt(2, userId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
