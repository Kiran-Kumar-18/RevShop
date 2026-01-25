package com.revshop.service;

import com.revshop.dao.IReviewDAO;
import com.revshop.dao.ReviewDaoImpl;
import com.revshop.model.Review;

public class ReviewServiceImpl implements IReviewService {

    private IReviewDAO reviewDAO = new ReviewDaoImpl();

    @Override
    public boolean submitReview(Review review) {
        return false;
    }

    @Override
    public boolean addReview(Review review) {
        reviewDAO.addReview(review);
        return false;
    }
}