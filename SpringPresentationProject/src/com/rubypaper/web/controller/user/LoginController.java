package com.rubypaper.web.controller.user;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserDAOJDBC;
import com.rubypaper.biz.user.UserVO;
import com.rubypaper.web.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPassword(password);

        UserDAO userDAO = new UserDAOJDBC();
        UserVO user = userDAO.getUser(vo);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "getBoardList.do";
        } else {
            return "login.html";
        }
    }
}
