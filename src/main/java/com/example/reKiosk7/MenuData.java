package com.example.reKiosk7;

import com.example.reKiosk7.MenuType.Burger;
import com.example.reKiosk7.MenuType.Desserts;
import com.example.reKiosk7.MenuType.Drinks;
import com.example.reKiosk7.MenuType.MenuType;

public class MenuData {

    public static MenuList<Menu> getMenus() {
        MenuList<Menu> menus = new MenuList<>();

        menus.add(new Burger(MenuType.BURGER, "ShackBurger", 6.9, new String[]{"토마토", "양상추", "쉑소스가 토핑된 치즈버거"}));
        menus.add(new Burger(MenuType.BURGER, "SmokeShack", 8.9, new String[]{"베이컨", "체리 페퍼에 쉑소스가 토핑된 치즈버거"}));
        menus.add(new Burger(MenuType.BURGER, "Cheeseburger", 6.9, new String[]{"포테이토 번과 비프패티", "치즈가 토핑된 치즈버거"}));
        menus.add(new Burger(MenuType.BURGER, "Hamburger", 5.4, new String[]{"비프패티를 기반으로 야채가 들어간 기본버거"}));

        menus.add(new Drinks(MenuType.DRINKS, "Sider", 1.0, new String[]{"사이다"}));
        menus.add(new Drinks(MenuType.DRINKS, "CocaCola", 1.5, new String[]{"콜라"}));
        menus.add(new Drinks(MenuType.DRINKS, "Mountain Dew", 1.3, new String[]{"마운틴 듀"}));
        menus.add(new Drinks(MenuType.DRINKS, "Fanta", 1.2, new String[]{"환타"}));

        menus.add(new Desserts(MenuType.DESSERTS, "French fries", 6.9, new String[]{"감자 튀김"}));
        menus.add(new Desserts(MenuType.DESSERTS, "Nugget King", 8.9, new String[]{"너겟 킹"}));
        menus.add(new Desserts(MenuType.DESSERTS, "Cheese stick", 6.9, new String[]{"치즈 스틱"}));
        menus.add(new Desserts(MenuType.DESSERTS, "Coleslaw", 5.4, new String[]{"코울슬로"}));
        return menus;
    }
}
