package com.rubypaper.polymorphism3;

// 다형성 = 상속 + Overriding + 형변환
public class TVUser {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();

        TV tv = (TV) beanFactory.getBean(args[0]);
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
