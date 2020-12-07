package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(TVConfiguration.class);
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext("com.rubypaper.tv");
        SamsungTV tv = (SamsungTV) container.getBean("tv");

        tv.powerOn();
        tv.powerOff();
        tv.volumeUp();
        tv.volumeDown();

        container.close();
    }
}
