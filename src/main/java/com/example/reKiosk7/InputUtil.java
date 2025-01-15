package com.example.reKiosk7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    private final Scanner sc;

    public InputUtil(Scanner sc) {
        this.sc = sc;
    }

    public int inputNum(int first, int size) {
        // Depth 를 3 이하로 하면 좋다는데
        // 무조건 3이하로 해야하는가?
        int num = -1;
        while (true) {
            try {
                num = sc.nextInt();
                if (first <= num && num <= size) break;
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
