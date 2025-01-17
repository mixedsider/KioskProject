package com.example.kiosk8;

import com.example.kiosk8.type.MenuItem;
import com.example.kiosk8.typelist.Cart;
import com.example.kiosk8.typelist.Menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk<T extends MenuItem> {


    private final int END = 0;

    private final Scanner sc = new Scanner(System.in);
    private final Menu<T> menus;
    private final Cart<T> cart = new Cart<>();
    private final int CATEGORY_SIZE;

    // 기본 생성자
    public Kiosk(Menu<T> menus) {
        this.menus = menus;
        this.CATEGORY_SIZE = menus.categorySize();
    }

    public void start() {
        //상위 메뉴
        int categoryNum = END;
        while (true) {
            // 상위 메뉴 출력
            showCategories();
            // 장바구니 메뉴 출력
            showCart(cart.isExist());

            //상위 메뉴 선택
            categoryNum = inputNum(cart.isExist() ? CATEGORY_SIZE + 2 : CATEGORY_SIZE);
            // 0 입력 시 종료
            if (categoryNum == END) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (categoryNum > menus.categorySize()) // 장바구니 조회
                showCartInner(categoryNum);
            else
                showItems(categoryNum); // 하위 메뉴
        }
    }

    // 상위 메뉴 출력
    private void showCategories() {
        /*boolean isExist*/
        System.out.println("[ MAIN MENU ]");
        menus.getMenuList().stream()
                .map(item -> item.getNum() + ". " + item.getCategory())
                .distinct()
                .forEach(System.out::println);
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
    }

    // 장바구니 출력
    private void showCart(boolean isExist) {
        if (!isExist) return;
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(CATEGORY_SIZE + 1 + ". Orders");
        System.out.println(CATEGORY_SIZE + 2 + ". Cancel");
    }

    // 하위 메뉴
    private void showItems(int num) {
        int itemNum = END;

        // 카테고리 선택 ( 입력 숫자 -1 == 배열 맞추기 )
        List<T> menuItems = menus.getMenuList(num);
        // 하위 메뉴 출력
        System.out.println("[ " + menuItems.get(0).getCategory() + "MENU" + " ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + ". " + menuItems.get(i).toString());
        }
        System.out.println("0. 뒤로가기");

        // 하위 메뉴 선택
        itemNum = inputNum(menuItems.size());

        // 0 입력시 뒤로 가기
        if (itemNum == END) {
            System.out.println("상위 메뉴로 돌아갑니다.");
            return;
        }

        // 장바구니 추가
        cart.add(menuItems.get(itemNum - 1));
        System.out.println("선택한 메뉴: " + menuItems.get(itemNum - 1));
    }


    // 장바구니 연산
    private void showCartInner(int num) {
        if (num == CATEGORY_SIZE + 2) {
            System.out.println("카트를 정리합니다.");
            cart.clear();
            return;
        }

        // 메뉴 출력
        System.out.println("[ Orders ]");
        cart.showItems();
        System.out.println();
        System.out.println("[ Total ]");
        double payMoney = cart.getPayMoney();
        System.out.println(" W " + payMoney);
        System.out.println(" 1. 주문 \t\t 2. 메뉴판");

        int input = inputNum(1, 2);
        if (input == 1) order(payMoney);
    }

    private void order(double payMoney) {
        // 할인 정보 입력 받기
        System.out.println("할인 정보를 입력해주세요.");
        Discount.showValues();
        int inputNum = inputNum(1, Discount.values().length);
        Discount discount = Discount.getNum(inputNum);

        // 계산
        String result = String.format("%.2f", discount.calculate(payMoney));
        System.out.println("주문이 완료되었습니다. 금액은 W " + result + " 입니다.");
        cart.clear();
    }

    // 숫자 입력 0 ~ last 까지
    private int inputNum(int last) {
        return inputNum(0, last);
    }

    // 숫자 입력 first ~ last 까지
    private int inputNum(int first, int last) {
        int num = END;
        while (true) {
            try {
                num = sc.nextInt();
                if (first <= num && num <= last) break;
                else throw new NumberFormatException("메뉴에 없습니다.");
            } catch (NumberFormatException e) { // 넘치는 숫자 입력
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) { // 문자 입력
                System.out.println("잘못된 입력입니다.");
                sc.next();
            }
        }

        return num;
    }
}
