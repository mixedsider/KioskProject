package com.example.kiosk3;

import com.example.kiosk3.MenuItem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    List<MenuItem> menuItems;

    // 기본 생성자
    public Kiosk() {
        this.menuItems = new ArrayList<>();
    }

    public void start() {

        // 메뉴 입력
        inputMenuItems();

        // 메뉴 출력
        printMenuItems();

        // 사용자 입력
        selectMenu();
    }

    private void inputMenuItems() {
        menuItems.add(new MenuItem("ShackBurger", 6.9, new String[]{"토마토", "양상추", "쉑소스가 토핑된 치즈버거"}));
        menuItems.add(new MenuItem("SmokeShack", 8.9, new String[]{"베이컨", "체리 페퍼에 쉑소스가 토핑된 치즈버거"}));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, new String[]{"포테이토 번과 비프패티", "치즈가 토핑된 치즈버거"}));
        menuItems.add(new MenuItem("Hamburger", 5.4, new String[]{"비프패티를 기반으로 야채가 들어간 기본버거"}));
    }

    private void printMenuItems() {
        for( int i = 0; i < menuItems.size(); i++ ) {
            MenuItem item = menuItems.get(i);
            System.out.println(i+1 + ". " + item.toString());
        }
        System.out.println("0. 종료" + "\t\t\t | " + "종료");
    }

    private void selectMenu() {
        Scanner sc = new Scanner(System.in);
        int selectNum = -1;

        while(true) {
            System.out.println("메뉴를 선택해주세요.");
            try {
                selectNum = sc.nextInt();
                if( !( 0 <= selectNum && selectNum <= menuItems.size() ) ) throw new NumberFormatException("메뉴에 없습니다.");
            } catch ( NumberFormatException e ) {
                System.out.println(e.getMessage());
                continue;
            } catch ( InputMismatchException e ) {
                System.out.println("잘못된 입력입니다.");
                sc.next();
                continue;
            }

            // 연산 & 출력
            switch (selectNum) {
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return; // 종료 or 되돌아가기
                }
                case 1, 2, 3, 4 -> {
                    // selectNum -1 위치 조정용
                    System.out.println("선택하신 메뉴 : " + menuItems.get(selectNum - 1).toString());
                }
                default -> {
                    System.out.println("아직 없는 메뉴입니다.");
                }
            }

            if( selectNum == 0 ) break;
        }
    }
}
