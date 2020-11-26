package com.rubypaper.biz.common;

import com.rubypaper.biz.user.UserVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Aspect
public class AfterThrowingAdvice {

    // returnObj : business logic을 수행한 후 리턴 값을 returnObj에 bind
    @AfterThrowing(pointcut = "BoardPointcut.allPointcut()", throwing = "exceptionObj")
    public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
        String method = jp.getSignature().getName();    // 클라이언트가 호출한 메소드 이름

        System.out.println("[ 예외처리 ]"+ method +" 메소드 수행 중  예외 발생");

        if(exceptionObj instanceof IllegalArgumentException){
            System.out.println("0 번 게시 글을 등록할 수 없습니다");
        } else if (exceptionObj instanceof ArithmeticException) {
            System.out.println("0 으로 숫자를 나눌 수 없습니다");
        } else if (exceptionObj instanceof SQLException) {
            System.out.println("SQL 구문에 오류가 있습니다");
        } else {
            System.out.println("문제 발생 !! 시스템을 잠시 종료합니다");
        }

    }
}
