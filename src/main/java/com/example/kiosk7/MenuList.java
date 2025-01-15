package com.example.kiosk7;

import java.util.ArrayList;
import java.util.List;

import static com.example.kiosk7.Main.END_NUMBER;
import static com.example.kiosk7.inputUtil.inputNum;

public class MenuList<T> implements IMenu<T> {

    private List<T> menuItems;

    public MenuList() {
        this.menuItems = new ArrayList<>();
    }

    public void add(T item) {
        this.menuItems.add(item);
    }

    // list
    @Override
    public boolean isExist() {
        return !this.menuItems.isEmpty();
    }

    @Override
    public List<T> getItemList() {
        return this.menuItems;
    }

    @Override
    public void setItemList(List<T> items) {
        this.menuItems = items;
    }

    @Override
    public T getItem(int i) {
        return this.menuItems.get(i);
    }

    @Override
    public void addItem(T item) {
        int inputNum = END_NUMBER;
        System.out.println("선택하신 메뉴 : " + item.toString());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");

        inputNum = inputNum(1, 2);
        if (inputNum == 0)
            this.menuItems.add(item);
    }

    @Override
    public void updateItem(int i, T item) {
        this.menuItems.set(i, item);
    }

    @Override
    public void deleteItem(int i) {
        this.menuItems.remove(i);
    }

    @Override
    public void clearItemList() {
        this.menuItems.clear();
    }

    @Override
    public int size() {
        return this.menuItems.size();
    }

    @Override
    public void showItems() {
        menuItems.forEach(item -> {
            System.out.println(menuItems.indexOf(item) + 1 + ". " + item.toString());
        });
    }
}
