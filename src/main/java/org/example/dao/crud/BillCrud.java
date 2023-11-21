package org.example.dao.crud;

import org.example.entity.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BillCrud implements GenericCrudI <Bill>{
    protected final List<Bill> billsList;

    public BillCrud () {
        this.billsList = new ArrayList<>();
    }

    @Override
    public void add(Bill entity) {
        billsList.add(entity);
    }

    @Override
    public void edit(Bill entity) {
        Integer billID = entity.getIdBill();
        billsList.set(billID, entity);
    }

    @Override
    public void remove(Bill entity) {
        billsList.remove(entity);
    }

    @Override
    public Bill findByID(Integer id) {
        Optional<Bill> bill = billsList.stream().filter(b -> Objects.equals(b.getIdBill(), id)).findFirst();
        if (bill.isEmpty()){
            System.out.println("Producto no encontrado en el inventario.");
            return null;
        }
        return bill.get();
    }

    @Override
    public List<Bill> findAll() {
        return billsList;
    }
}
