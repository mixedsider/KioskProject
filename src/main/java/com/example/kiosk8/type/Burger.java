package com.example.kiosk8.type;

public class Burger extends MenuItem {

    private final int num;

    private final String category;

    public Burger(int num, String category, String itemName, double itemPrice, String[] itemDescribeList) {
        super(itemName, itemPrice, itemDescribeList);
        this.num = num;
        this.category = category;
    }

    @Override
    public int getNum() {
        return this.num;
    }

    @Override
    public String getCategory() {
        return this.category;
    }
}
