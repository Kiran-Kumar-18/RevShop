package com.revshop.service;

import java.util.List;
import com.revshop.model.Product;

public interface IProductService {

    List<Product> fetchProducts();

    // ADD THIS
    List<Product> getProductsByCategory(int categoryId);
}
