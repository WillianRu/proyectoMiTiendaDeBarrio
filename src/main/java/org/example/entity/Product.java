package org.example.entity;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import org.example.service.CategoryConverter;

public class Product {
    private Integer idProduct;
    @CsvBindByPosition(position = 0)
    private String productName;
    @CsvBindByPosition(position = 1)
    private String description;
    @CsvCustomBindByPosition(position = 2, converter = CategoryConverter.class)
    private Category category;
    @CsvBindByPosition(position = 3)
    private String label;
    @CsvBindByPosition(position = 4)
    private Double price;
    @CsvBindByPosition(position = 5)
    private String urlPhoto;


    public Product(){

    }
    public Product(Integer idProduct, String productName, String description, String urlPhoto, Double price, Category category, String label) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.description = description;
        this.urlPhoto = urlPhoto;
        this.price = price;
        this.category = category;
        this.label = label;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Override
    public String toString() {
        return "idProduct=" + idProduct +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", price=" + price +
                ", category='" + category.getValue() + '\'' +
                ", label=" + label ;
    }
}
