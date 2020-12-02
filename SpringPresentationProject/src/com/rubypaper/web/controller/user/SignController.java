package com.rubypaper.web.controller.user;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserService;
import com.rubypaper.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SignController {
    private final UserService userService;

    @Autowired
    public SignController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login.do")
    public String login(UserVO vo, HttpSession session) {
        UserVO user = userService.getUser(vo);

        ModelAndView mav = new ModelAndView();
        if (user != null) {
            session.setAttribute("user", user);
            // forward: 이나 redirect: 을 뷰 이름 앞에 붙이면 ViewResolver를 무시한다
           return "forward:getBoardList.do";
        } else {
            return "login";
        }
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:index.jsp";
    }
}
