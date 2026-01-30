package com.revshop.service;

import com.revshop.dao.IReviewDAO;
import com.revshop.dao.ReviewDAOImpl;
import com.revshop.model.Review;

public class ReviewServiceImpl implements IReviewService {

    private IReviewDAO reviewDao = new ReviewDAOImpl();

    // ✅ Constructor name fixed
    public ReviewServiceImpl() throws Exception {
    }

    @Override
    public boolean addReview(Review review) {
        return reviewDao.addReview(review);
    }
}
