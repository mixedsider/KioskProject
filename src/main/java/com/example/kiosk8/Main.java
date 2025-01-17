package com.example.kiosk8;


import com.example.kiosk8.type.MenuItem;
import com.example.kiosk8.typelist.Menu;

public class Main {
    public static void main(String[] args) {

        // 데이터 가져오기
        Menu<MenuItem> menus = MenuData.getMenus();

        Kiosk<MenuItem> kiosk = new Kiosk(menus);
        kiosk.start();
    }
}