package com.rubypaper.web.common;

import com.rubypaper.biz.user.UserVO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleCheckFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        if (path.equals("/updateBoard.do") || path.equals("/deleteBoard.do")) {
            HttpSession session = request.getSession();
            UserVO user = (UserVO) session.getAttribute("user");
            if (user != null && user.getRole().equals("ADMIN")){
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
