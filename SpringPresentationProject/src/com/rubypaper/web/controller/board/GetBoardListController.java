package com.rubypaper.web.controller.board;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//public class GetBoardListController implements Controller {
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        // 1. ����� �Է����� ����
//        String searchCondition = request.getParameter("searchCondition");
//        String searchKeyword = request.getParameter("searchKeyword");
//
//        // Null Check
//        if (searchCondition == null) searchCondition = "TITLE";
//        if (searchKeyword == null) searchKeyword = "";
//
//        HttpSession session = request.getSession();
//        session.setAttribute("searchCondition", searchCondition);
//        session.setAttribute("searchKeyword", searchKeyword);
//        // 2. DB ���� ó��
//        BoardVO vo = new BoardVO();
//        vo.setSearchCondition(searchCondition);
//        vo.setSearchKeyword(searchKeyword);
//
//        BoardDAO boardDAO = new BoardDAOJDBC();
//        List<BoardVO> boardList = boardDAO.getBoardList(vo);
//
//        // 3. �˻� ����� ȭ��(JSP)���� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
//        session.setAttribute("boardList", boardList);
//
//        // �� ��� ȭ��(getBoardList.jsp)���� �̵��Ѵ�.
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("getBoardList");
//        return mav;
//    }
//}