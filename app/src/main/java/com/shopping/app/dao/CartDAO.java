package com.shopping.app.dao;

import com.shopping.app.model.CartItem;

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDAO implements DAO<CartItem> {
    private static final Map<Integer, CartItem> cartItemMap;

    static {
        cartItemMap = new HashMap<>();
    }

    @Override
    public CartItem getById(int id) {
        return cartItemMap.get(id);
    }

    @Override
    public boolean addOrUpdate(CartItem cartItem) {
        int itemId = cartItem.getItem().getId();
        if (!cartItemMap.containsKey(itemId)) {
            cartItemMap.put(itemId, cartItem);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(int id) {
        if (cartItemMap.containsKey(id)) {
            cartItemMap.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(CartItem cartItem) {
        return remove(cartItem.getItem().getId());
    }

    @Override
    public List<CartItem> getAll() {
        return new ArrayList<>(cartItemMap.values());
    }
}

