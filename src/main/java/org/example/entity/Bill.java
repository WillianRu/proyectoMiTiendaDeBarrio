package org.example.entity;

import java.time.LocalDate;
import java.util.Date;

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

    public Integer getIdBill() {
        return idBill;
    }
}
