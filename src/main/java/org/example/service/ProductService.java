package org.example.service;

import org.example.dao.crud.CategoryCrud;
import org.example.dao.crud.InventoryCrud;
import org.example.dao.crud.ProductCrud;
import org.example.entity.Category;
import org.example.entity.Inventory;
import org.example.entity.Product;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private final ProductCrud productCrud;
    private final InventoryCrud inventoryCrud;
    private org.example.entity.Category Category;
    private static int currentId=0;
    CategoryCrud categoryCrud = new CategoryCrud(Category);

    public ProductService(ProductCrud productCrud, InventoryCrud inventoryCrud) {
        this.productCrud = productCrud;
        this.inventoryCrud = inventoryCrud;
    }

    public void loadProducts(){
        try (FileReader reader = new FileReader("resources/correctedInventory.csv")) {
            CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
                    .withType(Product.class)
                    .withSeparator(';')
                    .withSkipLines(1)
                    .build();

            List<Product> products = csvToBean.parse();

            for (Product product : products) {
                product.setIdProduct(currentId);
                productCrud.add(product);
                currentId++;
                System.out.println(product.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del producto: ");
        String productName = scanner.nextLine();

        System.out.println("Ingrese la descripción del producto: ");
        String description = scanner.nextLine();

        System.out.println("Ingrese la etiqueta del producto: ");
        String label = scanner.nextLine();

        System.out.println("Ingrese la URL de la foto del producto: ");
        String urlPhoto = scanner.nextLine();

        System.out.println("Ingrese el precio del producto: ");
        double price = scanner.nextDouble();

        System.out.println("Categorias del producto: ");
        for (Category category : Category.values()){
            System.out.println(category.getId() + "." + category.getValue());
        }

        System.out.println("Digite el numero correspondiente a la categoria asociada: ");
        int categoryNumber = scanner.nextInt();
        Category category = categoryCrud.findByID(categoryNumber);

        System.out.println("Ingrese el stock disponible: ");
        int stock = scanner.nextInt();

        Inventory inventory = new Inventory (currentId,stock);
        inventoryCrud.add(inventory);

        Product product = new Product(currentId, productName, description, urlPhoto, price, category, label);
        productCrud.add(product);
        currentId++;
        System.out.println("Producto agregado con éxito.");
    }
    public void displayAllProducts() {
        List<Product> productList = productCrud.findAll();
        if (productList.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            System.out.println("Lista de Productos:");
            for (Product product : productList) {
                System.out.println(product.toString());
                System.out.println();
            }
        }
    }
    public void removeProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el id del producto a remover: ");
        Integer productID = scanner.nextInt();
        Product product = productCrud.findByID(productID);
        productCrud.remove(product);
        System.out.println("Producto eliminado con éxito.");
    }
    public void updateProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el id del producto por actualizar: ");
        Integer productID = scanner.nextInt();
        Product product = productCrud.findByID(productID);

        System.out.println("1. Nombre");
        System.out.println("2. Descripcion");
        System.out.println("3. Etiqueta");
        System.out.println("4. URL");
        System.out.println("5. Precio");

        System.out.println("Ingrese la opcion que desea actualizar: ");
        Integer option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> {
                System.out.println("Ingrese el nuevo nombre: ");
                String productName = scanner.nextLine();
                product.setProductName(productName);
            }
            case 2 -> {
                System.out.println("Ingrese la nueva descripcion: ");
                String productDescription = scanner.nextLine();
                product.setDescription(productDescription);
            }
            case 3 -> {
                System.out.println("Ingrese la nueva etiqueta: ");
                String productLabel = scanner.nextLine();
                product.setLabel(productLabel);
            }
            case 4 -> {
                System.out.println("Ingrese la nueva URL: ");
                String productURL = scanner.nextLine();
                product.setUrlPhoto(productURL);
            }
            case 5 -> {
                System.out.println("Ingrese el nuevo precio: ");
                Double productPrice = scanner.nextDouble();
                product.setPrice(productPrice);
            }
            default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }
        productCrud.edit(product);
        System.out.println("Producto actualizado con éxito.");
    }

}
