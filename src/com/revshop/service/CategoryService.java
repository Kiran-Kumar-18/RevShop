package com.revshop.service;

import java.util.List;

import com.revshop.dao.CategoryDAO;
import com.revshop.dao.ICategoryDAOImpl;
import com.revshop.model.Category;

public class CategoryService implements ICategoryServiceImpl {

    private ICategoryDAOImpl categoryDAO = new CategoryDAO();

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryDAO.getCategoryById(categoryId);
    }
}
