package com.rubypaper.web.controller.user;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPassword(password);

        UserDAO userDAO = new UserDAOJDBC();
        UserVO user = userDAO.getUser(vo);

        ModelAndView mav = new ModelAndView();
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // forward: 이나 redirect: 을 뷰 이름 앞에 붙이면 ViewResolver를 무시한다
            mav.setViewName("forward:getBoardList.do");
        } else {
            mav.setViewName("redirect:login.jsp");
        }
        return mav;
    }
}
