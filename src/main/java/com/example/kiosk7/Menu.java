package com.example.kiosk7;

import java.util.ArrayList;
import java.util.List;

public class Menu<T> implements IMenu<T>{

    private List<String> category;
    private List<T> list;

    // 생성자
    public Menu() {
        this.category = new ArrayList<>();
        this.list = new ArrayList<>();
    }

    // Getter, Setter

    public List<String> getCategoryList() {
        return this.category;
    }

    public String getCategory(int i) {
        return this.category.get(i);
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void add(String category, T list) {
        this.category.add(category);
        this.list.add(list);
    }

    @Override
    public boolean isExist() {
        return !this.list.isEmpty();
    }

    @Override
    public List<T> getItemList() {
        return this.list;
    }

    @Override
    public T getItem(int i) {
        return this.list.get(i);
    }

    @Override
    public void addItem(T item) {
        this.list.add(item);
    }

    @Override
    public void setItemList(List<T> items) {
        this.list = items;
    }

    @Override
    public void updateItem(int i, T item) {
        this.list.set(i, item);
    }

    @Override
    public void deleteItem(int i) {
        this.list.remove(i);
    }

    @Override
    public void clearItemList() {
        this.category.clear();
        this.list.clear();
    }

    public void showItems() {
        System.out.println("[ MAIN MENU ]");
        for( int i = 0; i < this.category.size(); i++ ) {
            System.out.println(i+1 + ". " + this.category.get(i));
        }
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
    }

    public int size() {
        return this.category.size();
    }
}
