package com.revshop.controller;

import com.revshop.service.*;
import com.revshop.model.*;
import java.util.List;

public class ProductController {
    ProductService service = new ProductService();
    public List<Product> view_products() {
        return service.fetch_products();
    }
}
