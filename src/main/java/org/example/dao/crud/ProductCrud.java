package org.example.dao.crud;

import org.example.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductCrud implements GenericCrudI<Product>{

    protected final List<Product> productList;

    public ProductCrud() {
        this.productList = new ArrayList<>();
    }

    @Override
    public void add (Product entity){
        productList.add(entity);
    }
    @Override
    public void edit (Product entity){
        Integer productID = entity.getIdProduct();
        productList.set(productID,entity);
    }
    @Override
    public void remove (Product entity){
        productList.remove(entity);
    }
    @Override
    public Product findByID(Integer id) {
        Optional<Product> product = productList.stream().filter(p -> Objects.equals(p.getIdProduct(), id)).findFirst();
        if (product.isEmpty()){
            System.out.println("Producto no encontrado en el inventario.");
            return null;
        }
        return product.get();
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

}
