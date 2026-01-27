package com.revshop.service;

import com.revshop.dao.IReviewDAOImpl;
import com.revshop.model.Review;

public class ReviewService implements IReviewService {

    private IReviewDAOImpl reviewDAO = new IReviewDAOImpl() {
        @Override
        public boolean addReview(Review review) {
            return false;
        }
    };

    @Override
    public boolean submitReview(Review review) {
        return reviewDAO.addReview(review);
    }

    @Override
    public boolean addReview(Review review) {
        return false;
    }
}