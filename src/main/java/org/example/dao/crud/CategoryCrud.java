package org.example.dao.crud;

import org.example.entity.Category;

import java.util.List;

public class CategoryCrud implements GenericCrudI<Category>{

    final private Category category;

    public CategoryCrud(Category category) {
        this.category = category;
    }

    @Override
    public void add(Category entity) {

    }

    @Override
    public void edit(Category entity) {

    }

    @Override
    public void remove(Category entity) {

    }

    @Override
    public Category findByID(Integer id) {

        for (Category category : Category.values()) {
            if (id.equals(category.getId())) {
                return category;
            }
        }
        System.out.println("Categoría no válida");
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}
