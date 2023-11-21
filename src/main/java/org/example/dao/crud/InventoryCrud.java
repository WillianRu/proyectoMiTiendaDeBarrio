package org.example.dao.crud;

import org.example.entity.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InventoryCrud implements GenericCrudI<Inventory>{

    protected final List<Inventory> inventoryList;

    public InventoryCrud() {
        this.inventoryList = new ArrayList<>();
    }
    @Override
    public void add(Inventory entity) {
        inventoryList.add(entity);
    }

    @Override
    public void edit(Inventory entity) {
        Integer productID = entity.getIdProduct();
        inventoryList.set(productID,entity);
    }

    @Override
    public void remove(Inventory entity) {
        inventoryList.remove(entity);
    }

    @Override
    public Inventory findByID(Integer id) {
        Optional<Inventory> inventory = inventoryList.stream().filter(p -> Objects.equals(p.getIdProduct(), id)).findFirst();
        if (inventory.isEmpty()){
            System.out.println("Producto no encontrado en el inventario.");
            return null;
        }
        return inventory.get();
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryList;
    }
}
