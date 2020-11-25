package com.rubypaper.polymorphism4;

public class LgTV implements TV {
    private Speaker speaker;

    public LgTV() {
        System.out.println("===> LgTV(1) 생성");
    }

    public LgTV(Speaker speaker) {
        System.out.println("===> LgTV(2) 생성");
        this.speaker = speaker;
    }

    public void powerOn() {
        System.out.println("LgTV---전원 켠다");
    }

    public void powerOff() {
        System.out.println("LgTV---전원 끈다");
    }

    public void volumeUp() {
        speaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
    }
}
