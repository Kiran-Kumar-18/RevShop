package com.revshop.service;

import java.util.List;

import com.revshop.dao.IFavoriteDAO;
import com.revshop.dao.FavoriteDAOImpl;
import com.revshop.model.Favorite;

public class FavoriteServiceImpl implements IFavoriteService {

    private IFavoriteDAO favoriteDao = new FavoriteDAOImpl();

    @Override
    public boolean addFavorite(Favorite favorite) {
        return favoriteDao.addFavorite(favorite);
    }

    @Override
    public List<Favorite> viewFavorites(int userId) {
        return favoriteDao.getFavoritesByUser(userId);
    }

    @Override
    public void removeFavorite(int favoriteId) {
        favoriteDao.removeFavorite(favoriteId);
    }
}
