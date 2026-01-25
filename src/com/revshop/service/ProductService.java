package com.revshop.service;

import java.util.List;
import com.revshop.dao.IProductDAO;
import com.revshop.dao.ProductDAO;
import com.revshop.model.Product;

public class ProductService {

    private final IProductDAO productDAO = new ProductDAO();

    public List<Product> fetchProducts() {
        return productDAO.fetchProducts();
    }
}
