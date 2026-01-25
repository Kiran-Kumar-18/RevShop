package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revshop.model.Favorite;
import com.revshop.util.JDBCUtil;

public class FavoriteDAO implements IFavoriteDAO {

    // 1️⃣ Add product to favorites
    @Override
    public void addFavorite(Favorite favorite) {

        String sql = "INSERT INTO favorites (user_id, product_id) VALUES (?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, favorite.getUserId());
            ps.setInt(2, favorite.getProductId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Favorite already exists or database error");
        }
    }

    // 2️⃣ Get all favorites of a user
    @Override
    public List<Favorite> getFavoritesByUser(int userId) {

        List<Favorite> favorites = new ArrayList<>();
        String sql = "SELECT * FROM favorites WHERE user_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Favorite fav = new Favorite();
                fav.setFavoriteId(rs.getInt("favorite_id"));
                fav.setUserId(rs.getInt("user_id"));
                fav.setProductId(rs.getInt("product_id"));
                fav.setCreatedAt(rs.getTimestamp("created_at"));

                favorites.add(fav);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return favorites;
    }

    // 3️⃣ Remove favorite by id
    @Override
    public void removeFavorite(int favoriteId) {

        String sql = "DELETE FROM favorites WHERE favorite_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, favoriteId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
