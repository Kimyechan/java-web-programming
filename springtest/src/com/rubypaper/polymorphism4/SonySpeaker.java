package com.rubypaper.polymorphism4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeaker implements Speaker {
    public SonySpeaker() {
        System.out.println("===> SonySpeaker 생성");
    }

    public void volumeUp() {
        System.out.println("SonySpeaker---소리 올린다");
    }

    public void volumeDown() {
        System.out.println("SonySpeaker---소리 내린다");
    }


}
