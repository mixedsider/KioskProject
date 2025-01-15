package com.example.kiosk7.MenuType;

import java.util.Arrays;
import java.util.List;

public enum MenuType {
    BURGER(0, "Burger"),
    DRINKS(1, "Drinks"),
    DESSERTS(2, "Desserts");

    private final int numberType;
    private final String stringType;

    MenuType(int numberType, String stringType) {
        this.numberType = numberType;
        this.stringType = stringType;
    }

    public static MenuType getTypeNum(int num) {
        return Arrays.stream(values())
                .filter(item -> item.getNumberType() == num)
                .findAny().orElse(null);
    }

    public static List<String> typeList() {
        return Arrays.stream(values())
                .map(MenuType::getStringType)
                .toList();
    }

    public static int size() {
        return MenuType.values().length;
    }

    public String getStringType() {
        return stringType;
    }

    public int getNumberType() {
        return numberType;
    }
}
