package com.revshop.controller;

import com.revshop.model.Product;
import com.revshop.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductController {

    private final ProductService productService;
    private final Scanner sc;

    public ProductController() {
        this.productService = new ProductService();
        this.sc = new Scanner(System.in);
    }

    public void productMenu() {

        int choice;
        do {
            System.out.println("\nPRODUCT FUNCTIONAL TEST MENU");
            System.out.println("1 Add Product");
            System.out.println("2 View All Products");
            System.out.println("3 Get Product By Id");
            System.out.println("4 Update Product");
            System.out.println("5 Delete Product");
            System.out.println("6 Update Stock");
            System.out.println("7 Check Product Exists");
            System.out.println("8 View By Category");
            System.out.println("9 View By Seller");
            System.out.println("10 Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showProducts();
                case 3 -> getProductById();
                case 4 -> updateProduct();
                case 5 -> deleteProduct();
                case 6 -> updateStock();
                case 7 -> checkProductExists();
                case 8 -> viewByCategory();
                case 9 -> viewBySeller();
                case 10 -> System.out.println("Exiting Product Module...");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 10);
    }

    // Add Product
    public void addProduct() {

        Product p = new Product();

        System.out.print("Enter Seller Id: ");
        p.setSellerId(sc.nextInt());

        System.out.print("Enter Category Id: ");
        p.setCategoryId(sc.nextInt());

        sc.nextLine(); // clear buffer
        System.out.print("Enter Product Name: ");
        p.setName(sc.nextLine());

        System.out.print("Enter Description: ");
        p.setDescription(sc.nextLine());

        System.out.print("Enter Price: ");
        p.setPrice(sc.nextDouble());

        System.out.print("Enter MRP: ");
        p.setMrp(sc.nextDouble());

        System.out.print("Enter Discount Price: ");
        p.setDiscountPrice(sc.nextDouble());

        System.out.print("Enter Stock Quantity: ");
        p.setStockQuantity(sc.nextInt());

        System.out.print("Enter Stock Threshold: ");
        p.setStockThreshold(sc.nextInt());

        p.setActive(true);

        boolean result = productService.addProduct(p);
        System.out.println(result ? " Product Added Successfully" : " Failed to Add Product");
    }

    // View All Products
    public void showProducts() {

        List<Product> products = productService.viewAllProducts();

        if (products == null || products.isEmpty()) {
            System.out.println(" No products available");
            return;
        }

        products.forEach(System.out::println);
    }

    // Get Product By Id
    public void getProductById() {

        System.out.print("Enter Product Id: ");
        int id = sc.nextInt();

        Product p = productService.getProductById(id);

        if (p == null) {
            System.out.println(" Product not found");
        } else {
            System.out.println(p);
        }
    }

    // Update Product
    public void updateProduct() {

        System.out.print("Enter Product Id: ");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Price: ");
        double price = sc.nextDouble();

        boolean result = productService.updateProduct(id, name, price);
        System.out.println(result ? " Product Updated" : " Update Failed");
    }

    // Delete Product
    public void deleteProduct() {

        System.out.print("Enter Product Id: ");
        int id = sc.nextInt();

        boolean result = productService.deleteProduct(id);
        System.out.println(result ? " Product Deleted" : " Delete Failed");
    }

    // Update Stock
    public void updateStock() {

        System.out.print("Enter Product Id: ");
        int id = sc.nextInt();

        System.out.print("Enter Quantity to Reduce: ");
        int qty = sc.nextInt();

        boolean result = productService.updateStock(id, qty);
        System.out.println(result ? " Stock Updated" : " Stock Update Failed");
    }

    // Check Product Exists (ONLY ONE METHOD)
    public void checkProductExists() {

        System.out.print("Enter Product Id: ");
        int id = sc.nextInt();

        boolean exists = productService.productExists(id);
        System.out.println(exists ? " Product Exists" : " Product Not Found");
    }

    // View By Category
    public void viewByCategory() {

        System.out.print("Enter Category Id: ");
        int catId = sc.nextInt();

        List<Product> products = productService.getProductsByCategory(catId);

        if (products == null || products.isEmpty()) {
            System.out.println(" No products found for Category ID: " + catId);
            return;
        }

        products.forEach(System.out::println);
    }

    // View By Seller
    public void viewBySeller() {

        System.out.print("Enter Seller Id: ");
        int sellerId = sc.nextInt();

        List<Product> products = productService.getProductsBySeller(sellerId);

        if (products == null || products.isEmpty()) {
            System.out.println(" No products found for Seller ID: " + sellerId);
            return;
        }

        products.forEach(System.out::println);
    }


}
