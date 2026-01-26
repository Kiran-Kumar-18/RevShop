package com.revshop.service;

import java.util.List;

import com.revshop.dao.IProductDAO;
import com.revshop.dao.ProductDAO;
import com.revshop.model.Product;

public class ProductService implements IProductService {

    private final IProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> fetchProducts() {
        return productDAO.fetchProducts();
    }

    // NOW THIS OVERRIDES CORRECTLY
    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        return productDAO.getProductsByCategory(categoryId);
    }
}
