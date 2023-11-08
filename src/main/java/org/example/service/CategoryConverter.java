package org.example.service;
import org.example.entity.Category;

import com.opencsv.bean.AbstractBeanField;

public class CategoryConverter extends AbstractBeanField<String, Category> {

    @Override
    protected Object convert(String value) {
        for (Category category : Category.values()) {
            if (category.getValue().equals(value)) {
                return category;
            }
        }
        // Si no se encuentra la categoría, puedes devolver una categoría por defecto o lanzar una excepción, dependiendo de tu lógica.
        return Category.DEFAULT_CATEGORY;
    }
}