package com.example.kiosk7;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menus;
    private final ShoppingCart shoppingCart;
    private final int END_NUMBER = -1;
    private Discount discount;

    // 기본 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.shoppingCart = new ShoppingCart();
    }

    public void start() {
        //상위 메뉴
        int categoryNum = END_NUMBER;
        while(true) {
            // 상위 메뉴 출력
            showMenuCategories(shoppingCart.isExist());
            //상위 메뉴 선택
            categoryNum = inputNum(0,
                    shoppingCart.isExist() ? menus.size()+2 : menus.size()
            );
            // 0 입력 시 종료
            if (categoryNum == END_NUMBER ) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if( categoryNum >= menus.size() ) callShoppingMenu(categoryNum);
            else callLowMenu(categoryNum);
        }
    }

    // 상위 메뉴 출력
    private void showMenuCategories(boolean isExist) {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i + 1 + ". " + menus.get(i).getMenuCategory());
        }
        System.out.println("0. 종료" + "\t\t\t | " + "종료");

        // 장바구니 출력
        if( isExist ) {
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println(menus.size() + 1 + ". Orders");
            System.out.println(menus.size() + 2 + ". Cancel");
        }
    }

    // 하위 메뉴
    private void callLowMenu( int num ) {
        int menuItemNum = END_NUMBER;
        // 카테고리 선택 ( 입력 숫자 -1 == 배열 맞추기 )
        List<MenuItem> menuItems = menus.get(num).getMenuItems();
        // 하위 메뉴 출력
        menus.get(num).showMenuItems();
        // 하위 메뉴 선택
        menuItemNum = inputNum(0, menuItems.size());
        // 0 입력시 뒤로 가기
        if( menuItemNum == END_NUMBER ) System.out.println("상위 메뉴로 돌아갑니다.");
        else {
            System.out.println("선택하신 메뉴 : " + menuItems.get(menuItemNum).toString());
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인\t\t2. 취소");
            int inputNum = inputNum(1, 2);
            if( inputNum == 0 ) shoppingCart.addShopping(menuItems.get(menuItemNum));
        }
    }

    // 장바구니 연산
    private void callShoppingMenu( int num ) {
        if( num == menus.size() + 1) {
            shoppingCart.clearShopping();
            return;
        }

        // 메뉴 출력
        shoppingCart.showShopping();
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println(" W " + shoppingCart.getHowMuch());

        System.out.println(" 1. 주문 \t\t 2. 메뉴판");
        int input = inputNum(1, 2);
        if( input == 0 ) {
            discount = inputPersonType();
            String result = String.format("%.2f", discount.calculate(shoppingCart.getHowMuch()));
            System.out.println("주문이 완료되었습니다. 금액은 W " + result + " 입니다.");
            shoppingCart.clearShopping();
        }
    }

    // 숫자 입력 받기
    private int inputNum(int first, int size) {
        Scanner sc = new Scanner(System.in);
        int num = -1;
        while ( true ) {
            try {
                num = sc.nextInt();
                if ( first <= num && num <= size ) break;
                else throw new NumberFormatException("메뉴에 없습니다.");
            } catch (NumberFormatException e) { // 넘치는 숫자 입력
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) { // 문자 입력
                System.out.println("잘못된 입력입니다.");
                sc.next();
            }
        }

        return num - 1;
    }

    private Discount inputPersonType() {
        System.out.println("할인 정보를 입력해주세요.");
        for( Discount a : Discount.values() ) {
            System.out.println(a.getTypeNum()+1 + ". " + a.getTypeStr() + " : " + a.getDiscountPercent() + "%");
        }
        int inputNum = inputNum(1, Discount.values().length);
        return Discount.getTypeNum(inputNum);
    }
}
