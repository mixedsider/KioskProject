package com.example.reKiosk7;

import com.example.reKiosk7.MenuType.MenuType;

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
}
