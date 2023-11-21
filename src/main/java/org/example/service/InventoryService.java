package org.example.service;

import org.example.dao.crud.InventoryCrud;
import org.example.dao.crud.ProductCrud;
import org.example.entity.Inventory;
import org.example.entity.Product;

import java.util.List;
import java.util.Random;

public class InventoryService {

    Random rand = new Random();
    List<Product> products;
    private final InventoryCrud inventoryCrud;
    private final ProductCrud productCrud;

    public InventoryService(InventoryCrud inventoryCrud, ProductCrud productCrud) { this.inventoryCrud = inventoryCrud;
        this.productCrud = productCrud;
    }

    public void loadStock(){
        products = productCrud.findAll();
        for (Product product: products) {
            int randomNumber = rand.nextInt(10);
            Integer currentID = product.getIdProduct();
            Inventory inventory = new Inventory(currentID, randomNumber);
            inventoryCrud.add(inventory);
        }
    }

    public boolean stockVerification(Integer pQuantity, Integer pId){
        Inventory currentInventory = inventoryCrud.findByID(pId);
        Integer currentStock = currentInventory.getStock();
        if (pQuantity > currentStock){
            System.out.println("No hay la cantidad suficiente de producto");
            return false;
        }
        return true;
    }
}
