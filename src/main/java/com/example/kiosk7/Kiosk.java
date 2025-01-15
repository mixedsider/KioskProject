package com.example.kiosk7;

import static com.example.kiosk7.Main.END_NUMBER;
import static com.example.kiosk7.inputUtil.inputNum;

public class Kiosk<T> {

    private final Menu<T> menu;
    private final MenuList<MenuItem> shoppingCart;
    private Discount discount;

    // 기본 생성자
    public Kiosk(Menu<T> menu) {
        this.menu = menu;
        this.shoppingCart = new MenuList<>();
    }

    public void start() {
        //상위 메뉴
        int categoryNum = END_NUMBER;
        while (true) {
            // 상위 메뉴 출력
            showMenuCategories(shoppingCart.isExist());

            //상위 메뉴 선택
            categoryNum = inputNum(0,
                    shoppingCart.isExist() ? menu.size() + 2 : menu.size()
            );
            // 0 입력 시 종료
            if (categoryNum == END_NUMBER) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (categoryNum >= menu.size()) callShoppingMenu(categoryNum);
            else {
                showMenuItems(categoryNum);
            }
        }
    }

    // 상위 메뉴 출력
    private void showMenuCategories(boolean isExist) {

        menu.showItems();

        // 장바구니 출력
        if (isExist) {
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println(menu.size() + 1 + ". Orders");
            System.out.println(menu.size() + 2 + ". Cancel");
        }
    }

    // 하위 메뉴
    private void showMenuItems(int num) {
        MenuList<MenuItem> menuList;
        int itemNum = END_NUMBER;

        // 카테고리 선택 ( 입력 숫자 -1 == 배열 맞추기 )
        menuList = (MenuList<MenuItem>) menu.getItemList().get(num);
        // 하위 메뉴 출력
        System.out.println("[ " + menu.getCategory(num) + " MENU" + " ]");
        menuList.showItems();
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
        // 하위 메뉴 선택
        itemNum = inputNum(0, menuList.size());

        // 0 입력시 뒤로 가기
        if (itemNum == END_NUMBER) {
            System.out.println("상위 메뉴로 돌아갑니다.");
            return;
        }
        shoppingCart.addItem(menuList.getItem(itemNum));
    }

    // 장바구니 연산
    private void callShoppingMenu(int num) {
        if (num == menu.size() + 1) {
            shoppingCart.clearItemList();
            return;
        }

        // 메뉴 출력
        System.out.println("[ Orders ]");
        shoppingCart.showItems();
        System.out.println();
        System.out.println("[ Total ]");
        double result = shoppingCart.getItemList().stream().mapToDouble(MenuItem::getItemPrice).sum();
        System.out.println(" W " + result);
        System.out.println(" 1. 주문 \t\t 2. 메뉴판");

        int input = inputNum(1, 2);
        if (input == 0) order(result);
    }

    private void order(double payMoney) {
        discount = inputPersonType();
        String result = String.format("%.2f", discount.calculate(payMoney));
        System.out.println("주문이 완료되었습니다. 금액은 W " + result + " 입니다.");
        shoppingCart.clearItemList();
    }

    private Discount inputPersonType() {
        System.out.println("할인 정보를 입력해주세요.");
        Discount.showType();
        int inputNum = inputNum(1, Discount.values().length);
        return Discount.getTypeNum(inputNum);
    }
}
