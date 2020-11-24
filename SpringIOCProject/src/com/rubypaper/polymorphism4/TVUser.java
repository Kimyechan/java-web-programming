package com.rubypaper.polymorphism4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 다형성 = 상속 + Overriding + 형변환
public class TVUser {
    public static void main(String[] args) {
        // 1. 스프링 IoC 컨테이너를 생성(구동)
        GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
//        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        for (String beanDefinitionName : container.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        // 2. 스프링 IoC 컨테이너로부터 객체를 검색(Lookup)한다
//        TV tv = (TV) container.getBean(args[0]);
//        TV tv = (TV) container.getBean(TV.class);

//        TV tv1 = (TV) container.getBean("tv", TV.class);
//        TV tv2 = (TV) container.getBean("tv", TV.class);
//        TV tv3 = (TV) container.getBean("tv", TV.class);

        // Spring Container는 Bean들을 Singleton으로 생성함 -> 여러번 호출하더라도 다 동일한 객체를 불러온다
//        System.out.println(tv1.toString());
//        System.out.println(tv2.toString());
//        System.out.println(tv3.toString());

        TV tv = (TV) container.getBean("tv");
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();

        // 3. 스프링 IoC 컨테이너를 종료한다. (컨테이너는 종료되기 직전에 자신이 관리하던 모든 객체를 삭제한다.)
        container.close();


    }
}
