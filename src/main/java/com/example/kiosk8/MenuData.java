package com.example.kiosk8;

import com.example.kiosk8.type.Burger;
import com.example.kiosk8.type.Desserts;
import com.example.kiosk8.type.Drinks;
import com.example.kiosk8.type.MenuItem;
import com.example.kiosk8.typelist.Menu;

public class MenuData {

    public static Menu<MenuItem> getMenus() {
        Menu<MenuItem> menus = new Menu<>();

        menus.add(new Burger(1, "Burger", "ShackBurger", 6.9, new String[]{"토마토", "양상추", "쉑소스가 토핑된 치즈버거"}));
        menus.add(new Burger(1, "Burger", "SmokeShack", 8.9, new String[]{"베이컨", "체리 페퍼에 쉑소스가 토핑된 치즈버거"}));
        menus.add(new Burger(1, "Burger", "Cheeseburger", 6.9, new String[]{"포테이토 번과 비프패티", "치즈가 토핑된 치즈버거"}));
        menus.add(new Burger(1, "Burger", "Hamburger", 5.4, new String[]{"비프패티를 기반으로 야채가 들어간 기본버거"}));

        menus.add(new Drinks(2, "Drinks", "Sider", 1.0, new String[]{"사이다"}));
        menus.add(new Drinks(2, "Drinks", "CocaCola", 1.5, new String[]{"콜라"}));
        menus.add(new Drinks(2, "Drinks", "Mountain Dew", 1.3, new String[]{"마운틴 듀"}));
        menus.add(new Drinks(2, "Drinks", "Fanta", 1.2, new String[]{"환타"}));

        menus.add(new Desserts(3, "Desserts", "French fries", 6.9, new String[]{"감자 튀김"}));
        menus.add(new Desserts(3, "Desserts", "Nugget King", 8.9, new String[]{"너겟 킹"}));
        menus.add(new Desserts(3, "Desserts", "Cheese stick", 6.9, new String[]{"치즈 스틱"}));
        menus.add(new Desserts(3, "Desserts", "Coleslaw", 5.4, new String[]{"코울슬로"}));
        return menus;
    }
}
