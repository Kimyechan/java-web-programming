package com.rubypaper.biz.common;

import com.rubypaper.biz.user.UserVO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
    @Pointcut("execution(!void com.rubypaper.biz..*Impl.*(..))")
    public void allPointcut() {}

    // returnObj : business logic을 수행한 후 리턴 값을 returnObj에 bind
    @AfterReturning(pointcut = "allPointcut()", returning = "returnObj")
    public void afterLog(Object returnObj) {
        System.out.println("<사후 처리> 비지니스 로직 리턴 값 : " + returnObj.toString());

        if (returnObj instanceof UserVO) {
            UserVO user = (UserVO) returnObj;
            if(user.getRole().equals("ADMIN")) {
                System.out.println(user.getName() + "님은 관리자 화면으로 바로 이동........");
            }
        }
    }
}
