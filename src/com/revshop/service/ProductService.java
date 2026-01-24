package com.revshop.service;

import com.revshop.dao.*;
import com.revshop.model.*;
import java.util.List;

public class ProductService {
    ProductDao dao = new ProductDao();
    public List<Product> fetch_products() {
        return dao.get_all_products();
    }
}
