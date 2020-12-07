package com.rubypaper.tv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.google"})
public class TVConfiguration {

    @Bean
    public SamsungTV tv() {
        return new SamsungTV(speaker());
    }

    @Bean
    public AppleSpeaker speaker(){
        return new AppleSpeaker();
    }
}
