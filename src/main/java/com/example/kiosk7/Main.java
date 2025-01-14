package com.example.kiosk7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menus = new ArrayList<>();

        // 메뉴 넣기
        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("ShackBurger", 6.9, new String[]{"토마토", "양상추", "쉑소스가 토핑된 치즈버거"}));
        burgers.add(new MenuItem("SmokeShack", 8.9, new String[]{"베이컨", "체리 페퍼에 쉑소스가 토핑된 치즈버거"}));
        burgers.add(new MenuItem("Cheeseburger", 6.9, new String[]{"포테이토 번과 비프패티", "치즈가 토핑된 치즈버거"}));
        burgers.add(new MenuItem("Hamburger", 5.4, new String[]{"비프패티를 기반으로 야채가 들어간 기본버거"}));
        Menu menu1 = new Menu("Burgers");
        menu1.setMenuItems(burgers);
        menus.add(menu1);

        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Sider", 1.0, new String[]{"사이다"}));
        drinks.add(new MenuItem("CocaCola", 1.5, new String[]{"콜라"}));
        drinks.add(new MenuItem("Mountain Dew", 1.3, new String[]{"마운틴 듀"}));
        drinks.add(new MenuItem("Fanta", 1.2, new String[]{"환타"}));
        Menu menu2 = new Menu("Drinks");
        menu2.setMenuItems(drinks);
        menus.add(menu2);

        List<MenuItem> desserts = new ArrayList<>();
        desserts.add(new MenuItem("French fries", 6.9, new String[]{"감자 튀김"}));
        desserts.add(new MenuItem("Nugget King", 8.9, new String[]{"너겟 킹"}));
        desserts.add(new MenuItem("Cheese stick", 6.9, new String[]{"치즈 스틱"}));
        desserts.add(new MenuItem("Coleslaw", 5.4, new String[]{"코울슬로"}));
        Menu menu3 = new Menu("Desserts");
        menu3.setMenuItems(desserts);
        menus.add(menu3);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}