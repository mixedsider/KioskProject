package com.example.kiosk8.typelist;

import com.example.kiosk8.type.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Menu<T extends MenuItem> {

    private final List<T> menuList;

    public Menu() {
        this.menuList = new ArrayList<>();
    }

    public void add(T item) {
        this.menuList.add(item);
    }

    public int size() {
        return this.menuList.size();
    }

    // 메뉴 카테고리 사이즈
    public int categorySize() {
        return (int) this.menuList.stream()
                .map(MenuItem::getNum)
                .distinct()
                .count();
    }

    public List<T> getMenuList() {
        return this.menuList;
    }

    public List<T> getMenuList(int num) {
        return menuList.stream()
                .filter(item -> item.getNum() == num)
                .toList();
    }
}
