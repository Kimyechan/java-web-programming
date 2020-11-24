package com.rubypaper.polymorphism4;

import java.sql.SQLOutput;

public class GoogleTV implements TV {
    private int price;

    public GoogleTV() {
        System.out.println("===>GoogleTV 생성");
    }

    public void 맴버변수초기화() {
        System.out.println("----> 맴버변수초기화() 호출");
        this.price = 1200000;
    }

    public void 자원해제() {
        System.out.println("---> 자원해제() 호출");
        this.price = 0;
    }

    public void powerOn() {
        System.out.println("GoogleTV---전원 켠다" + price);
    }

    public void powerOff() {
        System.out.println("GoogleTV---전원 끈다");
    }

    public void volumeUp() {
        System.out.println("GoogleTV---소리 올린다");
    }

    public void volumeDown() {
        System.out.println("GoogleTV---소리 내린다");
    }
}
