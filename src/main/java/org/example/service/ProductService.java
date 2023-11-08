package org.example.service;

import org.example.dao.crud.CategoryCrud;
import org.example.dao.crud.ProductCrud;
import org.example.entity.Category;
import org.example.entity.Product;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private final ProductCrud productCrud;
    private org.example.entity.Category Category;
    private static int currentId=0;
    CategoryCrud categoryCrud = new CategoryCrud(Category);

    public ProductService(ProductCrud productCrud) {
        this.productCrud = productCrud;
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




}
