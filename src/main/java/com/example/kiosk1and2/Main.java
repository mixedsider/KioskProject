package com.example.kiosk1and2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MenuItem> menuList = new ArrayList<>();
        int selectNum = -1;

        // 메뉴 입력
        menuList.add(new MenuItem("ShackBurger", 6.9, new String[]{"토마토", "양상추", "쉑소스가 토핑된 치즈버거"}));
        menuList.add(new MenuItem("SmokeShack", 8.9, new String[]{"베이컨", "체리 페퍼에 쉑소스가 토핑된 치즈버거"}));
        menuList.add(new MenuItem("Cheeseburger", 6.9, new String[]{"포테이토 번과 비프패티", "치즈가 토핑된 치즈버거"}));
        menuList.add(new MenuItem("Hamburger", 5.4, new String[]{"비프패티를 기반으로 야채가 들어간 기본버거"}));

        // 메뉴 출력
        for( int i = 0; i < menuList.size(); i++ ) {
            MenuItem item = menuList.get(i);
            System.out.println(i+1 + ". " + item.toString());
        }
        System.out.println("0. 종료" + "\t\t\t | " + "종료");

        // 사용자 입력
        while(true) {
            System.out.println("메뉴를 선택해주세요.");
            try {
                selectNum = sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            // 연산 & 출력
            switch (selectNum) {
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                }
                case 1, 2, 3, 4 -> {
                    // selectNum -1 위치 조정용
                    System.out.println("선택하신 메뉴 : " + menuList.get(selectNum - 1).toString());
                }
                default -> {
                    System.out.println("아직 없는 메뉴입니다.");
                }
            }

            if( selectNum == 0 ) break;
        }
    }
}