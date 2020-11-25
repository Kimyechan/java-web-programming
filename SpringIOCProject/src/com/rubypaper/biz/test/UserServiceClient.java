package test;

import com.rubypaper.biz.user.UserVO;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
    GenericXmlApplicationContext container =
            new GenericXmlApplicationContext("business-layer.xml");

    UserVO vo = new UserVO();
    vo.
}
