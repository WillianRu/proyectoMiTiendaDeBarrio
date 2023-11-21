package org.example.service;


import org.example.dao.crud.BillCrud;
import org.example.dao.crud.InventoryCrud;
import org.example.dao.crud.ProductCrud;
import org.example.entity.Bill;
import org.example.entity.Inventory;
import org.example.entity.Product;

import java.time.LocalDate;
import java.util.Scanner;

public class BillService {

    private final ProductCrud productCrud;
    private final InventoryCrud inventoryCrud;
    private final InventoryService inventoryService;
    private final BillCrud billCrud;
    public int currentId = 0;

    public BillService(ProductCrud productCrud, InventoryCrud inventoryCrud, BillCrud billCrud, InventoryService inventoryService) {
        this.productCrud = productCrud;
        this.inventoryCrud = inventoryCrud;
        this.billCrud = billCrud;
        this.inventoryService = inventoryService;
    }

    public void buyProducts(){
        Scanner scanner = new Scanner(System.in);
        boolean buyValidation = true;
        int quantity = 0;
        Double subtotal = 0.0;;
        Double total = 0.0;

        while (buyValidation){
            System.out.println("Ingrese el ID del producto a comprar:");
            Integer idProduct = scanner.nextInt();
            boolean c = false;

            while (!c){
                System.out.println("Ingrese la cantidad a comprar:");
                quantity = scanner.nextInt();
                c = inventoryService.stockVerification(quantity,idProduct);
            }

            Product currentProduct = productCrud.findByID(idProduct);
            Double currentPrice = currentProduct.getPrice();

            subtotal = currentPrice * quantity;

            System.out.println("¿Desea comprar algo más? (Sí: 1 / No: 0)");
            int choice = scanner.nextInt();
            buyValidation = (choice == 1);
        }

        Double tax = subtotal * 0.19;
        total += subtotal + tax;

        LocalDate currentDate = LocalDate.now();
        Bill bill = new Bill(currentDate,currentId,subtotal,total);
        billCrud.add(bill);
        currentId ++;
    }

}
