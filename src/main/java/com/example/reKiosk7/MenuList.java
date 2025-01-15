package com.example.kiosk7;

import com.example.kiosk7.MenuType.MenuType;

import java.util.ArrayList;
import java.util.List;

public class MenuList<T extends Menu> {


    private final List<Menu> menuList;

    public MenuList() {
        this.menuList = new ArrayList<>();
    }

    public boolean isExist() {
        return !this.menuList.isEmpty();
    }

    public void add(T item) {
        this.menuList.add(item);
    }

    public int size() {
        return this.menuList.size();
    }

    public void clear() {
        this.menuList.clear();
    }

    public void showItems() {
        this.menuList.forEach(item -> {
            System.out.println(item.toString());
        });
    }

    public List<T> getMenuList() {
        return (List<T>) this.menuList;
    }

    public List<T> getMenuList(MenuType type) {
        return (List<T>) menuList.stream()
                .filter(item -> item.getType() == type)
                .toList();
    }

    // list
//    @Override
//    public void addItem(T item) {
//        int inputNum = END_NUMBER;
//        System.out.println("선택하신 메뉴 : " + item.toString());
//        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
//        System.out.println("1. 확인\t\t2. 취소");
//
//        inputNum = inputNum(1, 2);
//        if (inputNum == 0)
//            this.menuItems.add(item);
//    }
//
//    @Override
//    public void showItems() {
//        menuItems.forEach(item -> {
//            System.out.println(menuItems.indexOf(item) + 1 + ". " + item.toString());
//        });
//        System.out.println("0. 종료" + "\t\t\t | " + "종료");
//    }
}
