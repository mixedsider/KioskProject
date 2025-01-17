# 내일배움캠프 CH 2 계산기 과제


## 개발 환경
- IntellJ IDEA Ultimate Edition 2024.3.1.1

- Java 17.0.11

- Github

- git 2.34.1

- ubuntu Ubuntu 22.04.5 LTS 64bit


## 개발자 블로그

    https://strnetwork.tistory.com/


## 프로그램 구성
![image](https://github.com/user-attachments/assets/8c003361-b972-4d32-9fe8-00cb8045cedb)



## 프로그램 사용법

    git clone https://github.com/mixedsider/KioskProject.git

./KioskProject/src/main/java/com/example/kiosk[원하는 레벨]/Main.java 에 있는 main 을 실행시키면 됩니다.


### 레벨별 차이

개발 기간 : 5일

- kiosk1 : 기본적인 키오스크 프로그래밍

- kiosk2 : 객체 지향 설계를 적용한 햄버거 메뉴를 클래스로 관리하기 ( kiosk1 에서 진행됨 )

- kiosk3 : 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기

- kiosk4 : 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기

- kiosk5 : 캡슐화 적용하기 ( 앞 kiosk 에서 진행됨 )

- kiosk6 : 장바구니 및 구매 기능을 추가하기

- kiosk7 : Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리

- kiosk8 : kiosk7 최종 리팩토링


## 개발하면서 공부한 내용

    https://strnetwork.tistory.com/45
    https://strnetwork.tistory.com/46


## 리펙토링 과정

    https://strnetwork.tistory.com/47
    https://strnetwork.tistory.com/48


## 트러블 슈팅

    https://strnetwork.tistory.com/44



### 배운점
- 클래스가 생성되면서 매번 같은 객체를 생성을 하게 되면 ( ex Scanner ) 메모리적으로 손해가 난다
    - 이럴 때는 외부에서 객체를 만들고 의존성을 주입해주면 된다. (Dependency Injection, DI)

- 클래스, 객체, 변수, 메소드 등 이름을 만드는 법에 대해서 생각을 해보게 되었다.

- Depth가 많으면 안좋지만 너무 적으면 알아야할 메소드가 많아진다는 것을 알게 되었다.

- 신입의 경우 문제 해결 능력에 초점이 있어야하고, 클린코드(책) 에 대해서 너무 신경을 쓰면 안된다. 오히려 유연성 있게 작성을 할 수 있어야한다.
  
- 객체 지향적으로 설계를 할 때 설계를 어떻게 진행을 해야되는지 생각을 하게 되었다.
    - 클래스를 설계를 할 때는 하나의 클래스가 여러가지의 역할을 가지면 안된다.
    - 연관이 깊은 메소드및 변수끼리 모여있어야한다.
    - 메소드를 나누는 것은 명확한 목적이 있어야한다.
    - 로직을 명확하게 해야한다.

- 유틸은 한 기능을 위해서 나누는 것이 아니다.

- 유지 관리 입장에서는 부모클래스와 자식클래스는 같은 패키지 안에 있는 것이 좋다.

- 타입은 오히려 정확한 것이 오히려 프로그램 상 좋다.

