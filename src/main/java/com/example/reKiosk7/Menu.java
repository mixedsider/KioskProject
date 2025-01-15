package com.example.reKiosk7;

import com.example.reKiosk7.MenuType.MenuType;

import java.util.List;

public abstract class Menu {
    private String itemName;
    private double itemPrice;
    private List<String> itemDescribeList;

    // 생성자
    public Menu(String itemName, double itemPrice, String[] itemDescribeList) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescribeList = List.of(itemDescribeList);
    }

    // Getter, Setter
    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public List<String> getItemDescribeList() {
        return this.itemDescribeList;
    }

    public void setItemDescribeList(String[] itemDescribeList) {
        this.itemDescribeList = List.of(itemDescribeList);
    }

    public abstract int getTypeNum();

    public abstract String getTypeStr();

    public abstract MenuType getType();

    @Override
    public String toString() {
        return itemName + " | W " + itemPrice + " | " + itemDescribeList.toString();
    }
}