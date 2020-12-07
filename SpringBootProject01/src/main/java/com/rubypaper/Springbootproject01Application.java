package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springbootproject01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootproject01Application.class, args);
        /*SpringApplication application = new SpringApplication(Springbootproject01Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);*/ // Tomcat 쓰지않고 사용 - 웹이 아닌 환경에서 사용
       /* SpringApplication application = new SpringApplication(Springbootproject01Application.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args); // Tomcat 사용 - 웹인 환경에서 사용*/
//        application.setBannerMode(Banner.Mode.OFF);
    }

}
