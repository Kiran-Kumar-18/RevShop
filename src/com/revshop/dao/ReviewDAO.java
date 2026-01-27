package com.revshop.dao;

import com.revshop.model.Review;
import com.revshop.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReviewDAO implements IReviewDAOImpl {

    @Override
    public boolean addReview(Review review) {
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into reviews(product_id,user_id,rating,comment) values(?,?,?,?)"
            );
            ps.setInt(1, review.getProductId());
            ps.setInt(2, review.getUserId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}