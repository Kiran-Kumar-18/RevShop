package com.revshop.controller;

import java.util.List;
import java.util.Scanner;

import com.revshop.model.Favorite;
import com.revshop.service.FavoriteService;
import com.revshop.service.IFavoriteService;

public class FavoriteController {

    private IFavoriteService favoriteService = new FavoriteService();
    private Scanner sc = new Scanner(System.in);

    // 1️⃣ Add product to favorites
    public void addFavorite(int userId) {

        Favorite favorite = new Favorite();

        favorite.setUserId(userId);

        System.out.print("Enter Product Id to add to favorite: ");
        int productId = sc.nextInt();
        favorite.setProductId(productId);

        favoriteService.addFavorite(favorite);
        System.out.println("Product added to favorites");
    }

    // 2️⃣ View favorites
    public void viewFavorites(int userId) {

        List<Favorite> favorites = favoriteService.viewFavorites(userId);

        if (favorites.isEmpty()) {
            System.out.println("No favorite products found");
            return;
        }

        System.out.println("\nYour Favorite Products:");
        for (Favorite f : favorites) {
            System.out.println(
                    "Favorite Id: " + f.getFavoriteId() +
                            " | Product Id: " + f.getProductId() +
                            " | Added On: " + f.getCreatedAt()
            );
        }
    }

    // 3️⃣ Remove favorite
    public void removeFavorite(int userId) {

        System.out.print("Enter Favorite Id to remove: ");
        int favoriteId = sc.nextInt();

        favoriteService.removeFavorite(favoriteId);
        System.out.println("Favorite removed successfully");
    }
}
