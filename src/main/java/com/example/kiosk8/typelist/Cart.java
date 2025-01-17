package com.example.kiosk8.typelist;

import com.example.kiosk8.type.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Cart<T extends MenuItem> {

    List<T> innerCart = new ArrayList<>();

    public Cart() {
    }

    public void add(T item) {
        this.innerCart.add(item);
    }

    public boolean isExist() {
        return !this.innerCart.isEmpty();
    }

    public void clear() {
        this.innerCart.clear();
    }

    public double getPayMoney() {
        return innerCart.stream()
                .mapToDouble(MenuItem::getItemPrice)
                .sum();
    }

    public void showItems() {
        this.innerCart.forEach(item -> {
            System.out.println(item.toString());
        });
    }
}
