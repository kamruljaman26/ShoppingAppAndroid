package com.shopping.app.database;

import com.shopping.app.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDatabase {
    private static final List<CartItem> cartItemList = new ArrayList<>();

    public CartItem getById(int id) {
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getItem().getId() == id) {
                return cartItem;
            }
        }
        return null;
    }

    public void addOrUpdate(CartItem cartItem) {
        int itemId = cartItem.getItem().getId();
        boolean itemExists = false;
        for (CartItem item : cartItemList) {
            if (item.getItem().getId() == itemId) {
                item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            cartItemList.add(cartItem);
        }
    }

    public boolean remove(int id) {
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getItem().getId() == id) {
                cartItemList.remove(cartItem);
                return true;
            }
        }
        return false;
    }

    public boolean remove(CartItem cartItem) {
        return remove(cartItem.getItem().getId());
    }

    public List<CartItem> getAll() {
        return cartItemList;
    }
}
