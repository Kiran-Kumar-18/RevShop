package com.revshop.model;

import java.time.LocalDateTime;

public class Product {

    private int productId;
    private int sellerId;
    private int categoryId;
    private String name;
    private String description;
    private double price;
    private double mrp;
    private double discountPrice;
    private int stockQuantity;
    private int stockThreshold;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Empty constructor
    public Product() {}

    // Constructor used while adding product
    public Product(int sellerId, int categoryId, String name, String description,
                   double price, double mrp, double discountPrice,
                   int stockQuantity, int stockThreshold) {
        this.sellerId = sellerId;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.mrp = mrp;
        this.discountPrice = discountPrice;
        this.stockQuantity = stockQuantity;
        this.stockThreshold = stockThreshold;
        this.active = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getSellerId() { return sellerId; }
    public void setSellerId(int sellerId) { this.sellerId = sellerId; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getMrp() { return mrp; }
    public void setMrp(double mrp) { this.mrp = mrp; }

    public double getDiscountPrice() { return discountPrice; }
    public void setDiscountPrice(double discountPrice) { this.discountPrice = discountPrice; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public int getStockThreshold() { return stockThreshold; }
    public void setStockThreshold(int stockThreshold) { this.stockThreshold = stockThreshold; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stockQuantity +
                ", categoryId=" + categoryId +
                ", sellerId=" + sellerId +
                '}';
    }
}
