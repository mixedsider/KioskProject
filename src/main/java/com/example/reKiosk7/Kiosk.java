package com.example.kiosk7;

import com.example.kiosk7.MenuType.MenuType;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.example.kiosk7.Main.END_NUMBER;

public class Kiosk<T extends Menu> {

    private final MenuList<T> menus;
    private final MenuList<T> shop;
    private final InputUtil iu;
    private Discount discount;

    // 기본 생성자
    public Kiosk(MenuList<T> menus) {
        this.menus = menus;
        this.shop = new MenuList<>();
        this.iu = new InputUtil(new Scanner(System.in));
    }

    public void start() {
        //상위 메뉴
        int categoryNum = END_NUMBER;
        while (true) {
            // 상위 메뉴 출력
            showCategories();
            // 장바구니 메뉴 출력
            showShop(shop.isExist());

            //상위 메뉴 선택
            categoryNum = iu.inputNum(0,
                    shop.isExist() ? MenuType.size() + 2 : MenuType.size()
            );
            // 0 입력 시 종료
            if (categoryNum == END_NUMBER) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (categoryNum >= MenuType.size()) // 장바구니 조회
                callShoppingMenu(categoryNum);
            else

                showItems(categoryNum);
        }
    }

    // 상위 메뉴 출력
    private void showCategories() {
        /*boolean isExist*/
        System.out.println("[ MAIN MENU ]");
        Arrays.stream(MenuType.values())
                .forEach(item -> {
                    System.out.println(item.getNumberType() + 1 + ". " + item.getStringType());
                });
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
    }

    // 장바구니 출력
    private void showShop(boolean isExist) {
        if (!isExist) return;
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(menus.size() + 1 + ". Orders");
        System.out.println(menus.size() + 2 + ". Cancel");
    }

    //     하위 메뉴
    private void showItems(int num) {
        int itemNum = END_NUMBER;
        MenuType mt = MenuType.getTypeNum(num);

        // 카테고리 선택 ( 입력 숫자 -1 == 배열 맞추기 )
        List<T> menuItems = menus.getMenuList(mt);
        // 하위 메뉴 출력
        System.out.println("[ " + mt.getStringType() + "MENU" + " ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + " " + menuItems.get(i).getItemName() +
                    " | W " + menuItems.get(i).getItemPrice() +
                    " | " + menuItems.get(i).toString());
        }
        System.out.println("0. 뒤로가기");
        // 하위 메뉴 선택
        itemNum = iu.inputNum(0, menuItems.size());

        // 0 입력시 뒤로 가기
        if (itemNum == END_NUMBER) {
            System.out.println("상위 메뉴로 돌아갑니다.");
        }

        // 장바구니 추가
        shop.add(menuItems.get(itemNum));
        System.out.println("선택한 메뉴: " + menuItems.get(itemNum));
    }


    // 장바구니 연산
    private void callShoppingMenu(int num) {
        if (num == menus.size() + 1) {
            shop.clear();
            return;
        }

        // 메뉴 출력
        System.out.println("[ Orders ]");
        shop.showItems();
        System.out.println();
        System.out.println("[ Total ]");
        double result = shop.getMenuList().stream().mapToDouble(Menu::getItemPrice).sum();
        System.out.println(" W " + result);
        System.out.println(" 1. 주문 \t\t 2. 메뉴판");

        int input = iu.inputNum(1, 2);
        if (input == 0) order(result);
    }

    private void order(double payMoney) {
        discount = inputPersonType();
        String result = String.format("%.2f", discount.calculate(payMoney));
        System.out.println("주문이 완료되었습니다. 금액은 W " + result + " 입니다.");
        shop.clear();
    }

    private Discount inputPersonType() {
        System.out.println("할인 정보를 입력해주세요.");
        Discount.showType();
        int inputNum = iu.inputNum(1, Discount.values().length);
        return Discount.getTypeNum(inputNum);
    }
}
