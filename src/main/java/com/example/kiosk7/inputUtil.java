package com.example.kiosk7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class inputUtil {
    public static int inputNum(int first, int size) {
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
}
