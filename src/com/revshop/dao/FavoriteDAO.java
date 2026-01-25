package com.revshop.dao;

import com.revshop.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDAO implements IFavoriteDAO {

    @Override
    public boolean addFavorite(int userId, int productId) {

        String sql = """
            INSERT INTO favorites(user_id, product_id)
            VALUES (?, ?)
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, productId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Already in favorites or error occurred");
        }
        return false;
    }

    @Override
    public boolean removeFavorite(int userId, int productId) {

        String sql = """
            DELETE FROM favorites
            WHERE user_id = ? AND product_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, productId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Integer> getFavoriteProductIds(int userId) {

        List<Integer> list = new ArrayList<>();

        String sql = """
            SELECT product_id
            FROM favorites
            WHERE user_id = ?
        """;

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("product_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
