package org.example.entity;

import java.time.LocalDate;

public class Bill {
    LocalDate date;
    private Integer idBill;
    private Double subtotal;
    private Double total;

    public Bill(LocalDate date, Integer idBill, Double subtotal, Double total) {
        this.date = date;
        this.idBill = idBill;
        this.subtotal = subtotal;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "date=" + date +
                ", idBill=" + idBill +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }

    public Integer getIdBill() {
        return idBill;
    }
}
