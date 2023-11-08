package org.example.dao;

import org.example.dao.crud.CategoryCrud;
import org.example.entity.Category;

public class CategoryDao extends CategoryCrud {

    public CategoryDao(Category category) {
        super(category);
    }
}
