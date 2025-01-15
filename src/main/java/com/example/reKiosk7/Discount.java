package com.example.reKiosk7;

import java.util.Arrays;

public enum Discount {
    NATIONAL(0, "국가유공자", 10),
    ARMY(1, "군인", 5),
    STUDENT(2, "학생", 3),
    DEFAULT(3, "일반", 0);

    private final int typeNum;
    private final String typeStr;
    private final int discountPercent;

    Discount(int typeNum, String typeStr, int discountPercent) {
        this.typeNum = typeNum;
        this.typeStr = typeStr;
        this.discountPercent = discountPercent;
    }

    public static Discount getTypeStr(String str) {
        return Arrays.stream(values())
                .filter(item -> item.typeStr.equals(str))
                .findAny().orElse(null);
    }

    public static Discount getTypeNum(int num) {
        return Arrays.stream(values())
                .filter(item -> item.getTypeNum() == num)
                .findAny().orElse(null);
    }

    public static void showType() {
        for (Discount a : Discount.values()) {
            System.out.println(a.getTypeNum() + 1 + ". " + a.getTypeStr() + " : " + a.getDiscountPercent() + "%");
        }
    }

    public int getTypeNum() {
        return this.typeNum;
    }

    public String getTypeStr() {
        return this.typeStr;
    }

    public double getDiscountPercent() {
        return this.discountPercent;
    }

    public double calculate(double price) {
        return price * (100 - this.discountPercent) / 100;
    }
}
