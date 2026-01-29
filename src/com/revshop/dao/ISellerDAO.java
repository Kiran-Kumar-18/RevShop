package com.revshop.dao;

import com.revshop.model.Seller;
import java.util.List;

public interface ISellerDAO {
    //calling methods
    void addSeller(Seller seller);

    Seller getSellerById(int sellerId);

    List<Seller> getAllSellers();
}
