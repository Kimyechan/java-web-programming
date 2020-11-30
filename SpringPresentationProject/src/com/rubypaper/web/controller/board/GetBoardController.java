package com.rubypaper.web.controller.board;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.web.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("�Խ� �� �� ��ȸ ��� ó��");

        // 1. ����� �Է����� ����
        String seq = request.getParameter("seq");

        // 2. DB ���� ó��
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        BoardDAO boardDAO = new BoardDAOJDBC();
        BoardVO board = boardDAO.getBoard(vo);

        // 3. �˻� ����� ���ǿ� ����ϰ� JSPȭ������ �̵��Ѵ�.
        HttpSession session = request.getSession();
        session.setAttribute("board", board);
        return "getBoard";
    }
}
