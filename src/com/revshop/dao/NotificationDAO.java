package com.revshop.dao;

import com.revshop.model.Notification;
import com.revshop.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO implements INotificationDAOImpl {

    @Override
    public void addNotification(Notification n) {

        // ✅ USE SEQUENCE DIRECTLY (NO TRIGGER)
        String sql =
                "INSERT INTO notifications " +
                        "(notification_id, user_id, title, message, type, is_read, created_at) " +
                        "VALUES (notifications_seq.NEXTVAL, ?, ?, ?, ?, 0, SYSTIMESTAMP)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, n.getUserId());
            ps.setString(2, n.getTitle());
            ps.setString(3, n.getMessage());
            ps.setString(4, n.getType());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Notification> getNotificationsByUser(int userId) {

        List<Notification> list = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE user_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Notification n = new Notification();
                n.setNotificationId(rs.getInt("notification_id"));
                n.setUserId(rs.getInt("user_id"));
                n.setTitle(rs.getString("title"));
                n.setMessage(rs.getString("message"));
                n.setType(rs.getString("type"));
                n.setRead(rs.getInt("is_read") == 1);
                n.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(n);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void markAsRead(int notificationId) {

        String sql = "UPDATE notifications SET is_read=1 WHERE notification_id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, notificationId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
