package com.example.kiosk7;

import com.example.kiosk7.MenuType.MenuType;

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
//    @Override
//    public String toString() {
//        sb.append(" ").append(this.itemName).append("\t").append(" | ");
//        sb.append(" W ").append(this.itemPrice).append("\t").append(" | ");
//        this.itemDescribeList.forEach(item -> {
//            sb.append(item).append(", ");
//        });
//        sb.delete(sb.length() - 2, sb.length() - 1); // 마지막 , 삭제용
//        return sb.toString();
//    }


//            System.out.println("[ MAIN MENU ]");
//        for (int i = 0; i < this.list.size(); i++) {
//        System.out.println(i + 1 + ". " + this.list.get(i));
//    }
//        System.out.println("0. 종료" + "\t\t\t | " + "종료");
