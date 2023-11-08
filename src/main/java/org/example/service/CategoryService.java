package org.example.service;

import org.example.dao.crud.CategoryCrud;

public class CategoryService {

    final private CategoryCrud categoryCrud;

    public CategoryService(CategoryCrud categoryCrud) {
        this.categoryCrud = categoryCrud;
    }
}
