package com.example.kiosk7;

import java.util.Arrays;
import java.util.function.Function;

public enum Discount{
    NATIONAL(0,"국가유공자", 10, (a) -> a * 0.9 ),
    ARMY(1,"군인", 5, (a) -> a * 0.95 ),
    STUDENT(2,"학생", 3, (a)-> a * 0.97),
    DEFAULT(3, "일반", 0,  a -> a);

    private final int typeNum;
    private final String typeStr;
    private final int discountPercent;
    private final Function<Double, Double> discount;

    Discount(int typeNum, String typeStr, int discountPercent, Function<Double, Double> discount) {
        this.typeNum = typeNum;
        this.typeStr = typeStr;
        this.discountPercent = discountPercent;
        this.discount = discount;
    }

    public int getTypeNum() {
        return this.typeNum;
    }

    public String getTypeStr() {
        return this.typeStr;
    }

    public int getDiscountPercent() {
        return this.discountPercent;
    }

    public double calculate( double price ) {
        return discount.apply(price);
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
        for( Discount a : Discount.values() ) {
            System.out.println(a.getTypeNum()+1 + ". " + a.getTypeStr() + " : " + a.getDiscountPercent() + "%");
        }
    }
}
