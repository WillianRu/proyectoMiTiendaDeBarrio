package org.example.views;
import org.example.entity.Category;
import org.example.service.ProductService;

import java.util.Scanner;

public class Menu {

    private ProductService productService;

    public Menu(ProductService productService) {
        this.productService = productService;
    }

    public void runMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            handleUserChoice(choice);
        } while (choice != 8);
    }
    public static void displayMenu() {

        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. Ver todos los productos               |");
        System.out.println("5. Vender productos                      |");
        System.out.println("6. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 6)  ");
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1 -> productService.createProduct(); //  Agregar producto
            case 2 -> productService.removeProduct(); //  Eliminar producto
            case 3 -> System.out.println(); //  Actualizar producto
            case 4 -> productService.displayAllProducts(); //  Ver todos los productos
            case 5 -> System.out.println(); //  Vender productos
            case 6 -> System.out.println("Saliendo ...");
            default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }

    }

    public static void displayCategories() {
        System.out.println("Categorías disponibles:");
        for (Category category : Category.values()) {
            System.out.println(category.ordinal() + ". " + category.getValue());
        }
    }
}
