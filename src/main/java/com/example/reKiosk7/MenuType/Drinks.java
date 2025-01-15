package com.example.kiosk7.MenuType;

import com.example.kiosk7.Menu;

public class Drinks extends Menu {
    private final MenuType menuType;

    public Drinks(MenuType menuType, String itemName, double itemPrice, String[] itemDescribeList) {
        super(itemName, itemPrice, itemDescribeList);
        this.menuType = menuType;
    }

    @Override
    public int getTypeNum() {
        return menuType.getNumberType();
    }

    @Override
    public String getTypeStr() {
        return menuType.getStringType();
    }

    @Override
    public MenuType getType() {
        return menuType;
    }
}
