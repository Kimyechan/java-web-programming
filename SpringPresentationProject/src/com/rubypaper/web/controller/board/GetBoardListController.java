package com.rubypaper.web.controller.board;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.web.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetBoardListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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

        BoardDAO boardDAO = new BoardDAOJDBC();
        List<BoardVO> boardList = boardDAO.getBoardList(vo);

        // 3. �˻� ����� ȭ��(JSP)���� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
        HttpSession session = request.getSession();
        session.setAttribute("boardList", boardList);

        // �� ��� ȭ��(getBoardList.jsp)���� �̵��Ѵ�.
        return "getBoardList";
    }
}
