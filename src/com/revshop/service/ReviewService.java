package com.revshop.service;

import com.revshop.dao.IReviewDAOImpl;

import com.revshop.dao.ReviewDAO;

import com.revshop.model.Review;

public class ReviewService implements IReviewServiceImpl {

    private IReviewDAOImpl reviewDao = new ReviewDAO();

    public ReviewService() throws Exception {
    }

    @Override
    public boolean submitReview(Review review) {
        return reviewDao.addReview(review);
    }
}