package com.revshop.service;

import java.util.List;
import com.revshop.model.Category;

public interface ICategoryServiceImpl {

    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);
}
