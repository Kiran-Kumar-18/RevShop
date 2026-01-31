package com.revshop.service;

import com.revshop.dao.ICategoryDAO;
import com.revshop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class FakeCategoryDAO implements ICategoryDAO {

    private final List<Category> categories = new ArrayList<>();

    @Override
    public boolean addCategory(Category category) {
        return categories.add(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }
}
