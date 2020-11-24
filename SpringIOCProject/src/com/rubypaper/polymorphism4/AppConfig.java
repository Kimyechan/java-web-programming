package com.rubypaper.polymorphism4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public TV tv() {
        return new GoogleTV();
    }
}
