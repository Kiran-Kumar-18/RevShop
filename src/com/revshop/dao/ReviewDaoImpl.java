package com.revshop.dao;

import com.revshop.model.Review;
import com.revshop.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReviewDaoImpl implements IReviewDAO {

    @Override
    public boolean addReview(Review review) {
        try (Connection conn = JDBCUtil.getConnection()) {
            // ✅ Enable autocommit
            conn.setAutoCommit(true);

            String sql = "INSERT INTO reviews VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, review.getReviewId());
            ps.setInt(2, review.getProductId());
            ps.setInt(3, review.getUserId());
            ps.setInt(4, review.getRating());
            ps.setString(5, review.getReviewComment());

            ps.executeUpdate(); // insert runs and auto-commits
            System.out.println("Review inserted into DB.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}