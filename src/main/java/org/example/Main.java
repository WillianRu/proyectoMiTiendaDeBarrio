package org.example;

import org.example.dao.crud.BillCrud;
import org.example.dao.crud.InventoryCrud;
import org.example.dao.crud.ProductCrud;
import org.example.entity.Inventory;
import org.example.service.BillService;
import org.example.service.InventoryService;
import org.example.service.ProductService;
import org.example.views.Menu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Inventory> inv;
        ProductCrud productCrud = new ProductCrud();
        InventoryCrud inventoryCrud = new InventoryCrud();
        ProductService productService = new ProductService(productCrud, inventoryCrud);
        productService.loadProducts();

        InventoryService inventoryService = new InventoryService(inventoryCrud, productCrud);
        inventoryService.loadStock();

        BillCrud billCrud = new BillCrud();
        BillService billService = new BillService(productCrud,inventoryCrud,billCrud,inventoryService);

        inv = inventoryCrud.findAll();
        for (Inventory e: inv) {
            System.out.println(e.toString());
        }
        Menu menu = new Menu(productService, billService);
        menu.runMenu();
    }
}