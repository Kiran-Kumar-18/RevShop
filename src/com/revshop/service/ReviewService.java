package com.revshop.service;

import com.revshop.dao.IReviewDAO;
import com.revshop.dao.ReviewDAO;
import com.revshop.model.Review;

public class ReviewService implements IReviewService {

    private IReviewDAO reviewDAO = new ReviewDAO();

    @Override
    public boolean submitReview(Review review) {
        return reviewDAO.addReview(review);
    }

    @Override
    public boolean addReview(Review review) {
        return false;
    }
}