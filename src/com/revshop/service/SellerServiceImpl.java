package com.revshop.service;

import com.revshop.dao.ISellerDAO;
import com.revshop.dao.SellerDAOImpl;
import com.revshop.model.Seller;

import java.util.List;

public class SellerServiceImpl implements ISellerService {

    private ISellerDAO sellerDAO = new SellerDAOImpl();

    @Override
    public void registerSeller(Seller seller) {

        // 🔹 Basic validation
        if (seller == null) {
            System.out.println(" Seller details cannot be null");
            return;
        }

        if (seller.getUserId() <= 0) {
            System.out.println(" Invalid User ID");
            return;
        }

        if (seller.getBusinessName() == null || seller.getBusinessName().isBlank()) {
            System.out.println(" Business name is required");
            return;
        }

        // 🔹 Call DAO only once
        sellerDAO.addSeller(seller);
    }

    @Override
    public Seller getSellerById(int sellerId) {
        return sellerDAO.getSellerById(sellerId);
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerDAO.getAllSellers();
    }
}
