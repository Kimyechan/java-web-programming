package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {
    @Pointcut("execution(* com.rubypaper.biz..*Impl.*(..))")
    public void allPointcut() {} // 참조형 메소드 : 구분시키기 위해서

    @Pointcut("execution(* com.rubypaper.biz..*Impl.get*(..))")
    public void getPointcut() {} // 참조형 메소드 : 구분시키기 위해서

    @Pointcut("execution(* com.rubypaper.biz.user.*Impl.*(..))")
    public void userPointcut() {} // 참조형 메소드 : 구분시키기 위해서

    @Pointcut("execution(* com.rubypaper.biz.board.*Impl.*(..))")
    public void boardPointcut() {} // 참조형 메소드 : 구분시키기 위해서
}
