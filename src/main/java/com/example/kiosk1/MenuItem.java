package com.example.kiosk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuItem {

    private String itemName;

    private double itemPrice;

    private List<String> itemInnerList;

    public MenuItem(String itemName, double itemPrice, String[] itemInner) {
        this.itemInnerList = new ArrayList<>();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemInnerList.addAll(Arrays.asList(itemInner));
    }

    // list CRUD
    public void addItemInner(String itemInner) {
        this.itemInnerList.add(itemInner);
    }

    public String getItemInner(int i) {
        return this.itemInnerList.get(i);
    }

    public void updateItemInner(int i, String itemInner) {
        this.itemInnerList.set(i, itemInner);
    }

    public void deleteItemInner(String itemInner) {
        this.itemInnerList.remove(itemInner);
    }


    // Getter, Setter
    public String getItemName() {
        return this.itemName;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    public List<String> getItemInnerList() {
        return this.itemInnerList;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemInnerList(List<String> itemInnerList) {
        this.itemInnerList = itemInnerList;
    }

    // Override
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(this.itemName);

        // 길이 조절용
        if( itemName.length() < 12 )
            sb.append("\t");

        sb.append(" | ");
        sb.append(" W ").append(this.itemPrice).append("\t").append(" | ");
        this.itemInnerList.forEach(item -> {
            sb.append(item).append(", ");
        });
        sb.delete(sb.length()-2 , sb.length()-1); // 마지막 , 삭제용
        return sb.toString();
    }
}
