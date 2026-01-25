package com.revshop.controller;

import java.util.ArrayList;
import java.util.List;
import com.revshop.model.Product;
import com.revshop.service.ProductService;

public class ProductController {

    private final ProductService service = new ProductService();

    //  Used for View Products (menu option 1)
    public void showProducts() {

        List<Product> products = service.fetchProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.println(
                    p.getProductId() + " | " +
                            p.getName() + " | ₹" +
                            p.getPrice()
            );
        }
    }

    //  USED BY CART (THIS WAS MISSING)
    public List<Integer> showProductsWithNumbers() {

        List<Product> products = service.fetchProducts();
        List<Integer> productIds = new ArrayList<>();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return productIds;
        }

        System.out.println("\nAvailable Products:");
        int i = 1;

        for (Product p : products) {
            productIds.add(p.getProductId());
            System.out.println(
                    i++ + ". " +
                            p.getName() + " | ₹" +
                            p.getPrice()
            );
        }

        return productIds;
    }
}
