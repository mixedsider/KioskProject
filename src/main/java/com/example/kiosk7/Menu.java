package com.example.kiosk7;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String menuCategory;
    private List<MenuItem> menuItems;

    // 생성자
    public Menu(String menuCategory) {
        this.menuCategory = menuCategory;
        this.menuItems = new ArrayList<>();
    }

    // Getter, Setter
    public String getMenuCategory() {
        return this.menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    // List
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void addMenuItems(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void updateMenuItem(int i, MenuItem menuItem) {
        this.menuItems.set(i, menuItem);
    }

    public void deleteMenuItems(int i) {
        this.menuItems.remove(i);
    }

    public void showMenuItems() {
        System.out.println("[ " + this.menuCategory + " MENU ]");
        menuItems.forEach(item -> {
            System.out.println(menuItems.indexOf(item) + 1 + ". " + item.toString());
        });
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
    }
}
