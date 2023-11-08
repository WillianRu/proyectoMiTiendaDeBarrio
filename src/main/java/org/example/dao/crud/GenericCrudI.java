package org.example.dao.crud;

import java.util.List;

public interface GenericCrudI<T> {
    void add(T entity);
    void edit(T entity);
    void remove(T entity);
    T findByID(Integer id);
    List<T> findAll();
}
