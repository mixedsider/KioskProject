package com.example.kiosk8.type;

import java.util.List;

public abstract class MenuItem {

    private final StringBuilder sb = new StringBuilder();
    private String itemName;
    private double itemPrice;
    private List<String> itemDescribeList;

    // 생성자
    public MenuItem(String itemName, double itemPrice, String[] itemDescribeList) {
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

    // 자식클래스 getter
    public abstract int getNum();

    public abstract String getCategory();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(itemName).append(" | W ").append(itemPrice).append(" | ");
        for (int i = 0; i < itemDescribeList.size(); i++) {
            result.append(itemDescribeList.get(i)).append(", ");
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }
}