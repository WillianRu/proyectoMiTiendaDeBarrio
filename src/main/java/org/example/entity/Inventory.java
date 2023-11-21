package org.example.entity;

public class Inventory {
    private Integer idProduct;
    private Integer stock;

    public Inventory(Integer idProduct, Integer stock) {
        this.idProduct = idProduct;
        this.stock = stock;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public Integer getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "idProduct=" + idProduct +
                ", stock=" + stock +
                '}';
    }
}
