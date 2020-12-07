package com.rubypaper.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV  {
    private final AppleSpeaker speaker;

    @Autowired
    public SamsungTV(AppleSpeaker speaker) {
        this.speaker = speaker;
    }

    public void powerOn() {
        System.out.println("SamsungTV---전원 켠다");
    }

    public void powerOff() {
        System.out.println("SamsungTV---전원 끈다");
    }

    public void volumeUp() {
        speaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
    }
}
