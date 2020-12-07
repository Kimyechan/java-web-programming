package com.rubypaper.web.common;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String encoding;
    private String name;

//    public CharacterEncodingFilter() {
//        System.out.println("===> CharacterEncodingFilter 생성");
//    }

    public void init(FilterConfig fConfig) throws ServletException {
        // web.xml 파일에 설정된 로컬 파라미터 정보 추출
        encoding = fConfig.getInitParameter("encoding");
        name = fConfig.getInitParameter("name");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 모든 서블릿(*.do)이 실행되기 직전에 인코딩을 처리한다.
        //System.out.println(name + "님이 만든 인코딩 휠터가 동작하고 있어요...");
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}