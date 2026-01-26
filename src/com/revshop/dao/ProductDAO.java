package com.revshop.dao;

import java.sql.*;
import java.util.*;
import com.revshop.model.Product;
import com.revshop.util.JDBCUtil;

public class ProductDAO implements IProductDAO {

    @Override
    public List<Product> fetchProducts() {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, name, price FROM products WHERE is_active = 1";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                products.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public boolean productExists(int productId) {
        String sql = "SELECT 1 FROM products WHERE product_id = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);
            return ps.executeQuery().next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {

        List<Product> products = new ArrayList<>();

        String sql =
                "SELECT product_id, name, price, category_id " +
                        "FROM products WHERE category_id = ? AND is_active = 1";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setCategoryId(rs.getInt("category_id"));
                products.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
