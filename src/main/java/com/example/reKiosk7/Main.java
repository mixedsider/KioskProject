package com.example.reKiosk7;


public class Main {
    public static final int END_NUMBER = -1;

    public static void main(String[] args) {

        // 데이터 가져오기
        MenuData data = new MenuData();
        
        MenuList<Menu> menus = data.getMenus();

        Kiosk<Menu> kiosk = new Kiosk(menus);
        kiosk.start();
    }
}