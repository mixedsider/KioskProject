package com.example.kiosk7;

import java.util.List;

public interface IMenu<T> {

    // List
    boolean isExist();

    List<T> getItemList();

    T getItem(int i);

    void addItem(T item);

    void setItemList(List<T> items);

    void updateItem(int i, T item);

    void deleteItem(int i);

    void clearItemList();

    void showItems();

    int size();
}