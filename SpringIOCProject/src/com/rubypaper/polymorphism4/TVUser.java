package com.rubypaper.polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

// 다형성 = 상속 + Overriding + 형변환
public class TVUser {
    public static void main(String[] args) {
        // 1. 스프링 IoC 컨테이너를 생성(구동)
        new GenericXmlApplicationContext("applicationContext.xml");

//        TV tv = (TV) beanFactory.getBean(args[0]);
//        tv.powerOn();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.powerOff();
    }
}
