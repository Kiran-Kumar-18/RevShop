package com.revshop.dao;

import com.revshop.model.Product;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAOImpl {

    private Connection conn;

    {
        try {
            conn = JDBCUtil.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addProduct(Product p) {
        String sql = """
            INSERT INTO products
            (seller_id, category_id, name, description, price, mrp, discount_price,
             stock_quantity, stock_threshold, is_active, created_at, updated_at)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getSellerId());
            ps.setInt(2, p.getCategoryId());
            ps.setString(3, p.getName());
            ps.setString(4, p.getDescription());
            ps.setDouble(5, p.getPrice());
            ps.setDouble(6, p.getMrp());
            ps.setDouble(7, p.getDiscountPrice());
            ps.setInt(8, p.getStockQuantity());
            ps.setInt(9, p.getStockThreshold());
            ps.setInt(10, 1);
            LocalDateTime now = LocalDateTime.now();

            ps.setTimestamp(11, Timestamp.valueOf(
                    p.getCreatedAt() != null ? p.getCreatedAt() : now));

            ps.setTimestamp(12, Timestamp.valueOf(
                    p.getUpdatedAt() != null ? p.getUpdatedAt() : now));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return false;
    }

    @Override
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM products WHERE product_id=? AND is_active=1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                return p;
            }
        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product p) {
        String sql = "UPDATE products SET name=?, price=?, updated_at=? WHERE product_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(4, p.getProductId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("exception is :" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {
        String sql = "UPDATE products SET is_active=0 WHERE product_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateStock(int productId, int qty) {
        String sql = "UPDATE products SET stock_quantity = stock_quantity - ? WHERE product_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setInt(2, productId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean productExists(int productId) {
        String sql = "SELECT 1 FROM products WHERE product_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            return ps.executeQuery().next();
        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = """
        SELECT product_id, name, price,
               stock_quantity, category_id, seller_id
        FROM products
        WHERE is_active = 1
    """;

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                p.setCategoryId(rs.getInt("category_id"));
                p.setSellerId(rs.getInt("seller_id"));

                list.add(p);
            }

        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return list;
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category_id=? AND is_active=1";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                p.setCategoryId(rs.getInt("category_id"));
                p.setSellerId(rs.getInt("seller_id"));

                list.add(p);
            }

        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return list;
    }


    @Override
    public List<Product> getProductsBySeller(int sellerId) {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE seller_id=? AND is_active=1";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, sellerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                p.setCategoryId(rs.getInt("category_id"));
                p.setSellerId(rs.getInt("seller_id"));

                list.add(p);
            }

        } catch (Exception e) {
            System.out.println("exception is :"+e.getMessage());
        }
        return list;
    }
}
