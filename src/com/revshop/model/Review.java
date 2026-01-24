package com.revshop.model;

import java.time.LocalDateTime;

public class Review {
    public int review_id;
    public int user_id;
    public int product_id;
    public int rating;
    public String comment;
    public LocalDateTime created_at;
}
