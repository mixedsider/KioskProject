package com.example.kiosk6;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<MenuItem> shoppingList;

    public ShoppingCart() {
        this.shoppingList = new ArrayList<>();
    }

    public boolean isExist() {
        return !shoppingList.isEmpty();
    }

    public void addShopping(MenuItem item) {
        this.shoppingList.add(item);
    }

    public void clearShopping() {
        this.shoppingList.clear();
    }

    public void showShopping() {
        System.out.println("[ Orders ]");
        this.shoppingList.forEach( item -> System.out.println(item.toString()));
    }

    public String getHowMuch() {
        double result = 0;
        for (int i = 0; i < shoppingList.size(); i++) {
            result += shoppingList.get(i).getItemPrice();
        }
        return " W " + result;
    }
}
