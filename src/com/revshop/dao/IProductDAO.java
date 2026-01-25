package com.revshop.dao;

import com.revshop.model.Product;
import com.revshop.util.JDBCUtil;
import java.sql.*;
import java.util.*;

public class ProductDao {

    public List<Product> get_all_products() {
        List<Product> list = new ArrayList<>();

        try (Connection con = JDBCUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from products")) {

            while (rs.next()) {
                Product p = new Product();
                p.product_id = rs.getInt("product_id");
                p.seller_id = rs.getInt("seller_id");
                p.category_id = rs.getInt("category_id");
                p.name = rs.getString("name");
                p.price = rs.getDouble("price");
                list.add(p);
            }
        } catch (Exception e) {}
        return list;
    }
}
