package com.revshop.service;

import com.revshop.dao.ICategoryDAO;
import com.revshop.dao.CategoryDAOImpl;
import com.revshop.model.Category;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    private ICategoryDAO categoryDao = new CategoryDAOImpl();

    @Override
    public boolean addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
