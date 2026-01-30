package com.revshop.service;

import java.util.List;
import com.revshop.util.LoggerUtil;

import com.revshop.dao.IProductDAO;
import com.revshop.dao.ProductDAOImpl;
import com.revshop.model.Product;

public class ProductServiceImpl implements IProductService {

    private final IProductDAO productDAO = new ProductDAOImpl();

    // ================= ADD PRODUCT =================
    public boolean addProduct(Product product) {
        try {
            boolean success = productDAO.addProduct(product);
            if (success) LoggerUtil.logInfo("Product added: " + product.getName());
            return success;
        } catch (Exception e) {
            LoggerUtil.logError("Error adding product", e);
            return false;
        }
    }

    @Override
    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public boolean updateProduct(int productId, String name, double price) {
        Product p = new Product();
        p.setProductId(productId);
        p.setName(name);
        p.setPrice(price);
        return productDAO.updateProduct(p);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }

    @Override
    public boolean productExists(int productId) {
        return productDAO.productExists(productId);
    }

    // ================= VIEW ALL PRODUCTS =================
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    // ================= VIEW BY SELLER =================
    public List<Product> getProductsBySeller(int sellerId) {
        return productDAO.getProductsBySeller(sellerId);
    }

    // ================= VIEW BY CATEGORY (FIXED & FINAL) =================
    public List<Product> getProductsByCategory(int categoryId) {
        return productDAO.getProductsByCategory(categoryId);
    }

    // ================= UPDATE STOCK =================
    public boolean updateStock(int productId, int qty) {
        return productDAO.updateStock(productId, qty);
    }
}
