package com.shopping.app.dao;

import java.util.List;

public interface DAO<T> {

    T getById(int id);
    boolean addOrUpdate(T item);
    boolean remove(int id);
    boolean remove(T item);
    List<T> getAll();

}
