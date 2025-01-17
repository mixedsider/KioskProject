package com.example.kiosk8;

import java.util.Arrays;

public enum Discount {
    NATIONAL(1, "국가유공자", 10),
    ARMY(2, "군인", 5),
    STUDENT(3, "학생", 3),
    DEFAULT(4, "일반", 0);

    private final int num;
    private final String str;
    private final int discountPercent;

    Discount(int typeNum, String str, int discountPercent) {
        this.num = typeNum;
        this.str = str;
        this.discountPercent = discountPercent;
    }

    public static Discount getStr(String str) {
        return Arrays.stream(values())
                .filter(item -> item.str.equals(str))
                .findAny().orElse(null);
    }

    public static Discount getNum(int num) {
        return Arrays.stream(values())
                .filter(item -> item.getNum() == num)
                .findAny().orElse(null);
    }

    // Discount 목록 보여주기
    public static void showValues() {
        for (Discount a : Discount.values()) {
            System.out.println(a.getNum() + 1 + ". " + a.getStr() + " : " + (int) a.getDiscountPercent() + "%");
        }
    }

    public int getNum() {
        return this.num;
    }

    public String getStr() {
        return this.str;
    }

    public double getDiscountPercent() {
        return this.discountPercent;
    }

    // 할인 계산
    public double calculate(double price) {
        return price * (100 - this.discountPercent) / 100;
    }
}
