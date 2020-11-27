package com.rubypaper.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class BoardDAOSpring {
    // 스프링 컨테이너에 자동 등록된 빈을 주입
    @Autowired
    private JdbcTemplate spring;

    private static final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " +
            "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
    private static final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
    private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
    private static final String BOARD_DELETE = "DELETE BOARD WHERE SEQ=?";
    private static final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
    private static final String BOARD_LIST_TITLE = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
    private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";

    public void insertBoard(BoardVO vo) {
        System.out.println("====> Spring 기반 insertBoard");
        spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    public void updateBoard(BoardVO vo) {
        System.out.println("====> Spring 기반 updateBoard");
        spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
    }

    public void deleteBoard(BoardVO vo) {
        System.out.println("====> Spring 기반 deleteBoard");
        spring.update(BOARD_DELETE, vo.getSeq());
    }

    public BoardVO getBoard(BoardVO vo) {
        System.out.println("====> Spring 기반 getBoard");
        BoardVO board = null;
        return board;
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("====> Spring 기반 getBoardList");
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        return boardList;
    }
}




