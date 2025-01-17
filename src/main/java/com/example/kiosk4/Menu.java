package com.example.kiosk4;

import java.util.*;

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
        for( int i = 0; i < this.menuItems.size(); i++ ) {
            MenuItem item = this.menuItems.get(i);
            System.out.println(i+1 + ". " + item.toString());
        }
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
    }
}
