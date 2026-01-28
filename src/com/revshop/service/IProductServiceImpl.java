package com.revshop.service;

import com.revshop.model.Product;
import java.util.List;

public interface IProductServiceImpl {

    boolean addProduct(Product product);

    Product getProductById(int productId);

    boolean updateProduct(int productId, String name, double price);

    boolean deleteProduct(int productId);

    boolean updateStock(int productId, int qty);

    List<Product> viewAllProducts();

    boolean productExists(int productId);

    List<Product> getProductsByCategory(int categoryId);

    List<Product> getProductsBySeller(int sellerId);
}
