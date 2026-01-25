package com.revshop.dao;

import java.util.List;
import com.revshop.model.Favorite;

public interface IFavoriteDAO {

    // Add a product to favorites
    void addFavorite(Favorite favorite);

    // Get all favorites of a user
    List<Favorite> getFavoritesByUser(int userId);

    // Remove favorite using favorite id
    void removeFavorite(int favoriteId);
}
