package com.rubypaper.web.controller.board;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 1. ����� �Է����� ����
        String seq = request.getParameter("seq");

        // 2. DB ���� ó��
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAOJDBC();
        boardDAO.deleteBoard(vo);

        // 3. ȭ�� �׺���̼�
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:getBoardList.do");
        return mav;
    }
}
