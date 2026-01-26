package com.revshop.controller;

import java.util.List;
import java.util.Scanner;

import com.revshop.model.Category;
import com.revshop.service.CategoryService;
import com.revshop.service.ICategoryServiceImpl;

public class CategoryController implements ICategoryControllerImpl {

    private ICategoryServiceImpl categoryService = new CategoryService();
    private Scanner sc = new Scanner(System.in);

    // ===== SHOW ALL CATEGORIES =====
    @Override
    public void showAllCategories() {

        List<Category> categories = categoryService.getAllCategories();

        System.out.println("\n=== Categories ===");
        for (Category c : categories) {
            System.out.println(
                    c.getCategoryId() + " | " +
                            c.getCategoryName() + " | " +
                            c.getDescription()
            );
        }
    }

    // ===== SHOW CATEGORY BY ID =====
    @Override
    public void showCategoryById() {

        System.out.print("Enter Category Id: ");
        int categoryId = Integer.parseInt(sc.nextLine());

        Category c = categoryService.getCategoryById(categoryId);

        if (c != null) {
            System.out.println("\nCategory Details");
            System.out.println("Id   : " + c.getCategoryId());
            System.out.println("Name : " + c.getCategoryName());
            System.out.println("Desc : " + c.getDescription());
        } else {
            System.out.println("Category not found");
        }
    }
    public void showProductsOfCategory() {

        System.out.print("Enter Category Id: ");
        int categoryId = Integer.parseInt(sc.nextLine());

        ProductController productController = new ProductController();
        productController.showProductsByCategory(categoryId);
    }

}
