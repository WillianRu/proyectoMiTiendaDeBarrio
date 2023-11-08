package org.example;

import org.example.dao.crud.ProductCrud;
import org.example.service.ProductService;
import org.example.views.Menu;

public class Main {
    public static void main(String[] args) {
        ProductCrud productCrud = new ProductCrud();
        ProductService productService = new ProductService(productCrud);
        productService.loadProducts();
        Menu menu = new Menu(productService);
        menu.runMenu();
    }
}