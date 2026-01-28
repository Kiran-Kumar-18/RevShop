package com.revshop.service;

import com.revshop.dao.IProductDAOImpl;
import com.revshop.dao.ProductDAO;
import com.revshop.model.Product;

import java.util.List;

public class ProductService implements IProductServiceImpl {

    private final IProductDAOImpl productDAO = new ProductDAO();

    @Override
    public boolean addProduct(Product product) {
        if (product.getPrice() > product.getMrp()) {
            System.out.println("Price cannot be greater than MRP");
            return false;
        }
        return productDAO.addProduct(product);
    }

    @Override
    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public boolean updateProduct(int productId, String name, double price) {
        if (!productExists(productId)) return false;

        Product product = productDAO.getProductById(productId);
        product.setName(name);
        product.setPrice(price);

        return productDAO.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }

    @Override
    public boolean updateStock(int productId, int qty) {
        return productDAO.updateStock(productId, qty);
    }

    @Override
    public List<Product> viewAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public boolean productExists(int productId) {
        return productDAO.productExists(productId);
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        return productDAO.getProductsByCategory(categoryId);
    }

    @Override
    public List<Product> getProductsBySeller(int sellerId) {
        return productDAO.getProductsBySeller(sellerId);
    }
}
