package org.example.dao.crud;

import org.example.entity.Product;

import java.util.ArrayList;
import java.util.List;

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

    }
    @Override
    public void remove (Product entity){
        productList.remove(entity);
    }
    @Override
    public Product findByID(Integer id) {
        for (int i= 0; i<productList.size(); i++){
            if(productList.get(i).getIdProduct()==id){
                return productList.get(i);
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

}
