package com.example.kiosk4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menus;

    // 기본 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        final int END_NUMBER = -1;

        //상위 메뉴
        int categoryNum = END_NUMBER;
        while(true) {
            // 상위 메뉴 출력
            showMenuCategories();
            //상위 메뉴 선택
            categoryNum = inputNum(menus.size());
            // 0 입력 시 종료
            if (categoryNum == END_NUMBER ) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }


            // 하위 메뉴
            int menuItemNum = END_NUMBER;
            // 카테고리 선택 ( 입력 숫자 -1 == 배열 맞추기 )
            List<MenuItem> menuItems = menus.get(categoryNum).getMenuItems();
            // 하위 메뉴 출력
            menus.get(categoryNum).showMenuItems();
            // 하위 메뉴 선택
            menuItemNum = inputNum(menuItems.size());
            // 0 입력시 뒤로 가기
            if( menuItemNum == END_NUMBER ) System.out.println("상위 메뉴로 돌아갑니다.");
            else System.out.println("선택하신 메뉴 : " + menuItems.get(menuItemNum).toString());
        }
    }

    // 상위 메뉴 출력
    private void showMenuCategories() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i + 1 + ". " + menus.get(i).getMenuCategory());
        }
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
    }

    // 숫자 입력 받기
    private int inputNum(int size) {
        Scanner sc = new Scanner(System.in);
        int num = -1;
        while ( true ) {
            try {
                num = sc.nextInt();
                if ( 0 <= num && num <= size ) break;
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
}
