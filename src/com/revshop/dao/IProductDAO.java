package com.revshop.dao;

import java.util.List;
import com.revshop.model.Product;

public interface IProductDAO {
    List<Product> fetchProducts();
    boolean productExists(int productId);
    List<Product> getProductsByCategory(int categoryId);
}
