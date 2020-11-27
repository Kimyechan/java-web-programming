package com.example.aop;

import java.lang.annotation.*;

/**
 * 이 애노테이션을 사용하면 성능을 로깅합니다
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface PerfLogging {
}
