package com.revshop.service;

import java.util.List;
import com.revshop.dao.FavoriteDAO;
import com.revshop.model.Favorite;

public class FavoriteService implements IFavoriteService {

    private FavoriteDAO favoriteDAO = new FavoriteDAO();

    @Override
    public void addFavorite(Favorite favorite) {
        favoriteDAO.addFavorite(favorite);
    }

    @Override
    public List<Favorite> viewFavorites(int userId) {
        return favoriteDAO.getFavoritesByUser(userId);
    }

    @Override
    public void removeFavorite(int favoriteId) {
        favoriteDAO.removeFavorite(favoriteId);
    }
}
