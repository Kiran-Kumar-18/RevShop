package com.revshop.main;

import com.revshop.controller.CartController;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        CartController cart = new CartController();

        int user_id = 1;

        cart.addProduct(user_id, 101, 2);
        cart.addProduct(user_id, 102, 1);
        cart.showCart(user_id);

        cart.removeProduct(user_id, 101);
        cart.showCart(user_id);
    }
}
