package com.rubypaper.polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
    // @Autowired : Type Injection
    // 변수의 타입을 기준으로 의존성 주입을 처리한다
    // 해당 타입의 객체가 메모리에 있기만하면 컨테이너가 그 객체를 변수에 할당한다
    // 만약 주입할 객체가 없으면 Exception 발생
//    @Autowired
    private Speaker speaker;
//    private AppleSpeaker appleSpeaker;
//    private int price;

//    public SamsungTV() {
//        System.out.println("===> SamsungTV(1) 생성");
//    }

    @Autowired
    public SamsungTV(Speaker speaker) {
        System.out.println("===> SamsungTV(2) 생성");
        this.speaker = speaker;
//        this.appleSpeaker = appleSpeaker;
    }

//    public SamsungTV(Speaker speaker, int price) {
//        System.out.println("===> SamsungTV(3) 생성");
//        this.speaker = speaker;
//        this.price = price;
//    }

    /*public void setSpeaker(Speaker speaker) {
        System.out.println("---> setSpeaker 호출");
        this.speaker = speaker;
    }

    public void setPrice(int price) {
        System.out.println("---> setPrice() 호출");
        this.price = price;
    }*/

    public void powerOn() {
        System.out.println("SamsungTV---전원 켠다");
//        System.out.println(price);
    }

    public void powerOff() {
        System.out.println("SamsungTV---전원 끈다");
    }

    public void volumeUp() {
        speaker.volumeUp();
//        appleSpeaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
//        appleSpeaker.volumeUp();
    }
}
