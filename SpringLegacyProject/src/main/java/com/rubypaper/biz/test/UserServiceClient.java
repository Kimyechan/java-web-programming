package com.rubypaper.biz.test;

import com.rubypaper.biz.user.UserService;
import com.rubypaper.biz.user.UserVO;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
    public static void main(String[] args) {
        GenericXmlApplicationContext container =
                new GenericXmlApplicationContext("business-common.xml");

        UserService userService = container.getBean(UserService.class);

        UserVO vo = new UserVO();
        vo.setId("admin");
        vo.setPassword("admin");
        UserVO user = userService.getUser(vo);
        if(user != null) {
            System.out.println(user.getName() + "님 환영합니다.");
        } else {
            System.out.println("로그인 실패");
        }

        container.close();
    }

}
