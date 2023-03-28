package com.shopping.app.dao;

import com.shopping.app.model.CartItem;

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDAO implements DAO<CartItem> {
    private final Map<Integer, CartItem> cartItemMap;

    public CartDAO() {
        cartItemMap = new HashMap<>();
    }

    @Override
    public CartItem getById(int id) {
        return cartItemMap.get(id);
    }

    @Override
    public boolean addOrUpdate(CartItem cartItem) {
        if (cartItemMap.containsKey(cartItem.getItem().getId())) {
            cartItemMap.put(cartItem.getItem().getId(), cartItem);
            return true;
        } else {
            cartItemMap.put(cartItem.getItem().getId(), cartItem);
            return false;
        }
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

