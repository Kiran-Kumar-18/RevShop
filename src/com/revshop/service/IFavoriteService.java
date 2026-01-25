package com.revshop.service;

import java.util.List;
import com.revshop.model.Favorite;

public interface IFavoriteService {

    // Add product to favorites
    void addFavorite(Favorite favorite);

    // View all favorites of a user
    List<Favorite> viewFavorites(int userId);

    // Remove favorite by favorite id
    void removeFavorite(int favoriteId);
}
