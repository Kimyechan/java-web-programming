package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// around는 사전처리와 사후처리를 모두할 수 있다. (서블릿의 Filter와 동일하게 동작)
//@Service("around")
@Service
@Aspect
public class AroundAdvice {

    @Around("BoardPointcut.allPointcut()")
    public Object aroundLog(ProceedingJoinPoint jp) throws Throwable { // spring container 실행
        String method = jp.getSignature().getName();    // 클라이언트가 호출한 메소드 이름

        Object obj = null;
        System.out.println("---- < Before Logic >");
        StopWatch watch = new StopWatch();
        watch.start();

        obj = jp.proceed(); // jp.proceed() -> business logic, 없으면 business logic 실행안함

        watch.stop();
        System.out.println(method + "() 비지니스 메소드 수행에 소요된 시간: " + watch.getTotalTimeMillis());
        System.out.println("---- < After Logic > ");
        return obj;
    }
}
