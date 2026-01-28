package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revshop.model.Category;
import com.revshop.util.JDBCUtil;

public class CategoryDAO implements ICategoryDAOImpl {

    @Override
    public List<Category> getAllCategories() {

        List<Category> categories = new ArrayList<>();
        String sql = "SELECT category_id, name, description FROM categories";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("name")); // ✅ FIX
                category.setDescription(rs.getString("description"));
                categories.add(category);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {

        Category category = null;
        String sql =
                "SELECT category_id, name, description FROM categories WHERE category_id = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("name")); // FIX
                category.setDescription(rs.getString("description"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return category;
    }
}
