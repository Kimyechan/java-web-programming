package com.rubypaper.web.controller;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        System.out.println("===> DispatcherServlet ����");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. ����� ��û path ������ �����Ѵ�.
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);

        // 2. ����� path�� ���� ��û�� �б�ó���Ѵ�.
        if (path.equals("/login.do")) {
            System.out.println("�α��� ��� ó��");

            // 1. ����� �Է����� ����
            String id = request.getParameter("id");
            String password = request.getParameter("password");

            // 2. DB ���� ó��
            UserVO vo = new UserVO();
            vo.setId(id);
            vo.setPassword(password);

            UserDAO userDAO = new UserDAO();
            UserVO user = userDAO.getUser(vo);

            // 3. ȭ�� �׺���̼�
            if (user != null) {
                // �α��� ���� ��, ���ǿ� ���������� �����Ѵ�.
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("getBoardList.do");
            } else {
                response.sendRedirect("login.html");
            }

        } else if (path.equals("/logout.do")) {
            System.out.println("�α׾ƿ� ��� ó��");

            // �α׾ƿ��� ��û�� �������� �ش��ϴ� ���� ��ü�� ���� �����Ѵ�.
            HttpSession session = request.getSession();
            session.invalidate();

            response.sendRedirect("login.html");

        } else if (path.equals("/insertBoard.do")) {
            System.out.println("�Խ� �� ��� ��� ó��");

            // 1. ����� �Է����� ����
            String title = request.getParameter("title");
            String writer = request.getParameter("writer");
            String content = request.getParameter("content");

            // 2. DB ���� ó��
            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setWriter(writer);
            vo.setContent(content);

            BoardDAO boardDAO = new BoardDAO();
            boardDAO.insertBoard(vo);

            // 3. ȭ�� �׺���̼�
            response.sendRedirect("getBoardList.do");

        } else if (path.equals("/updateBoard.do")) {
            System.out.println("�Խ� �� ���� ��� ó��");

            // 1. ����� �Է����� ����
            String title = request.getParameter("title");
            String seq = request.getParameter("seq");
            String content = request.getParameter("content");

            // 2. DB ���� ó��
            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setSeq(Integer.parseInt(seq));
            vo.setContent(content);

            BoardDAO boardDAO = new BoardDAO();
            boardDAO.updateBoard(vo);

            // 3. ȭ�� �׺���̼�
            response.sendRedirect("getBoardList.do");

        } else if (path.equals("/deleteBoard.do")) {
            System.out.println("�Խ� �� ���� ��� ó��");

            // 1. ����� �Է����� ����
            String seq = request.getParameter("seq");

            // 2. DB ���� ó��
            BoardVO vo = new BoardVO();
            vo.setSeq(Integer.parseInt(seq));

            BoardDAO boardDAO = new BoardDAO();
            boardDAO.deleteBoard(vo);

            // 3. ȭ�� �׺���̼�
            response.sendRedirect("getBoardList.do");

        } else if (path.equals("/getBoard.do")) {
            System.out.println("�Խ� �� �� ��ȸ ��� ó��");

            // 1. ����� �Է����� ����
            String seq = request.getParameter("seq");

            // 2. DB ���� ó��
            BoardVO vo = new BoardVO();
            vo.setSeq(Integer.parseInt(seq));

            BoardDAO boardDAO = new BoardDAO();
            BoardVO board = boardDAO.getBoard(vo);

            // 3. �˻� ����� ���ǿ� ����ϰ� JSPȭ������ �̵��Ѵ�.
            HttpSession session = request.getSession();
            session.setAttribute("board", board);
            response.sendRedirect("getBoard.jsp");

        } else if (path.equals("/getBoardList.do")) {
            System.out.println("�Խ� �� ��� �˻� ��� ó��");

            // 1. ����� �Է����� ����
            String searchCondition = request.getParameter("searchCondition");
            String searchKeyword = request.getParameter("searchKeyword");

            // Null Check
            if (searchCondition == null) searchCondition = "TITLE";
            if (searchKeyword == null) searchKeyword = "";

            // 2. DB ���� ó��
            BoardVO vo = new BoardVO();
            vo.setSearchCondition(searchCondition);
            vo.setSearchKeyword(searchKeyword);

            BoardDAO boardDAO = new BoardDAO();
            List<BoardVO> boardList = boardDAO.getBoardList(vo);

            // 3. �˻� ����� ȭ��(JSP)���� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
            HttpSession session = request.getSession();
            session.setAttribute("boardList", boardList);

            // �� ��� ȭ��(getBoardList.jsp)���� �̵��Ѵ�.
            response.sendRedirect("getBoardList.jsp");

        } else {
            System.out.println("URL�� �ٽ� Ȯ�����ֽñ� �ٶ��ϴ�.");
        }
    }
}
