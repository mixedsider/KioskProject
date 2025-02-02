package com.example.kiosk3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuItem {

    private String itemName;

    private double itemPrice;

    private List<String> itemDescribeList;

    public MenuItem(String itemName, double itemPrice, String[] itemDescribe) {
        this.itemDescribeList = new ArrayList<>();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescribeList.addAll(Arrays.asList(itemDescribe));
    }

    // list CRUD
    public void addItemDescribe(String itemDescribe) {
        this.itemDescribeList.add(itemDescribe);
    }

    public String getItemDescribe(int i) {
        return this.itemDescribeList.get(i);
    }

    public void updateItemDescribe(int i, String itemDescribe) {
        this.itemDescribeList.set(i, itemDescribe);
    }

    public void deleteItemDescribe(String itemDescribe) {
        this.itemDescribeList.remove(itemDescribe);
    }


    // Getter, Setter
    public String getItemName() {
        return this.itemName;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }

    public List<String> getItemDescribeList() {
        return this.itemDescribeList;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemDescribeList(List<String> itemDescribeList) {
        this.itemDescribeList = itemDescribeList;
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
        this.itemDescribeList.forEach(item -> {
            sb.append(item).append(", ");
        });
        sb.delete(sb.length()-2 , sb.length()-1); // 마지막 , 삭제용
        return sb.toString();
    }
}
