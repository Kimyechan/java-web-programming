package com.rubypaper.web.controller.board;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//public class InsertBoardController implements Controller {
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        // 1. ����� �Է����� ����
//        String title = request.getParameter("title");
//        String writer = request.getParameter("writer");
//        String content = request.getParameter("content");
//
//        // 2. DB ���� ó��
//        BoardVO vo = new BoardVO();
//        vo.setTitle(title);
//        vo.setWriter(writer);
//        vo.setContent(content);
//
//        BoardDAO boardDAO = new BoardDAOJDBC();
//        boardDAO.insertBoard(vo);
//
//        // 3. ȭ�� �׺���̼�
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("forward:getBoardList.do");
//        return mav;
//    }
//}
