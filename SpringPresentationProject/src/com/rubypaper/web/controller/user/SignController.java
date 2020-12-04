package com.rubypaper.web.controller.user;

import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserService;
import com.rubypaper.biz.user.UserVO;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class SignController {
    private final UserService userService;

    @Autowired
    public SignController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(UserVO vo){
        vo.setId("admin");
        vo.setPassword("admin");
        return "login";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
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
