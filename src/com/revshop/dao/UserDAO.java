package com.revshop.dao;

import java.sql.*;

import com.revshop.model.User;
import com.revshop.util.JDBCUtil;

public class UserDAO implements IUserDAO {

    // ✅ LOGIN
    @Override
    public int login(String email, String password) {

        String sql = """
            SELECT user_id
            FROM users
            WHERE email = ? AND password_hash = ?
        """;

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

        return -1; // login failed
    }

    // ✅ REGISTER
    @Override
    public boolean register(String name, String email, String password) {

        String checkSql = "SELECT 1 FROM users WHERE email = ?";
        String insertSql = """
            INSERT INTO users (user_id, name, email, password_hash)
            VALUES (users_seq.NEXTVAL, ?, ?, ?)
        """;

        try (Connection con = JDBCUtil.getConnection()) {

            // Check duplicate email
            PreparedStatement check = con.prepareStatement(checkSql);
            check.setString(1, email);
            if (check.executeQuery().next()) {
                return false;
            }

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

    // ✅ VIEW USER PROFILE
    @Override
    public User getUserById(int userId) {

        String sql = """
            SELECT user_id, name, email, phone, role, created_at, updated_at
            FROM users
            WHERE user_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setRole(rs.getString("role"));

                Timestamp created = rs.getTimestamp("created_at");
                Timestamp updated = rs.getTimestamp("updated_at");

                if (created != null) {
                    u.setCreatedAt(created.toLocalDateTime());
                }

                if (updated != null) {
                    u.setUpdatedAt(updated.toLocalDateTime());
                }

                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // ✅ UPDATE PROFILE (with UPDATED_AT support)
    @Override
    public boolean updateProfile(User user) {

        String sql = """
            UPDATE users
            SET name = ?, phone = ?, updated_at = SYSDATE
            WHERE user_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setInt(3, user.getUserId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ✅ CHANGE PASSWORD
    @Override
    public boolean changePassword(int userId, String newPassword) {

        String sql = """
            UPDATE users
            SET password_hash = ?, updated_at = SYSDATE
            WHERE user_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPassword);
            ps.setInt(2, userId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ✅ CHECK EMAIL EXISTS
    @Override
    public boolean emailExists(String email) {

        String sql = "SELECT 1 FROM users WHERE email = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            return ps.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
