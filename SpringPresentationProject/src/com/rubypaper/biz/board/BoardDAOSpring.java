package com.rubypaper.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// 2. DAO (Data Access Object) 클래스
//@Repository // Component 기능을 가지고 있다.
@Repository
//@Primary
public class BoardDAOSpring implements BoardDAO{
    @Autowired
    private JdbcTemplate spring;

    // BOARD 테이블 관련 SQL 명령어
    private static final String BOARD_INSERT = "insert into board(seq, title, writer, content) " +
            "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
//                "values(?, ?, ?, ?)";
    private static final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
    private static final String BOARD_UPDATE_CNT = "update board set CNT = CNT + 1 WHERE SEQ = ?";
    private static final String BOARD_DELETE = "delete board where seq = ?";
    private static final String BOARD_GET = "select * from board where seq = ?";
    private static final String BOARD_LIST = "select * from board order by seq desc";
    private static final String BOARD_LIST_TITLE = "select * from board where TITLE like '%'||?||'%' order by seq desc"; // ? 에는 ''가 붙어서 들어가므로 따로 2개 만들어야함.
    private static final String BOARD_LIST_CONTENT = "select * from board where CONTENT like '%'||?||'%' order by seq desc";

    // BOARD 테이블 관련 CRUD 기능의 메소드
    // 글 등록
    public void insertBoard(BoardVO vo) {
        System.out.println("===> Spring 기반으로 insertBoard() 기능 처리");
        spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    // 글 수정
    public void updateBoard(BoardVO vo) {
        System.out.println("===> Spring 기반으로 updateBoard() 기능 처리");
        spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
    }

    public void deleteBoard(BoardVO vo) {
        System.out.println("===> Spring 기반으로 deleteBoard() 기능 처리");
        spring.update(BOARD_DELETE, vo.getSeq());
    }

    // 글 상세 조회
//    public Map<String, Object> getBoard(BoardVO vo) {
//        System.out.println("===> Spring 기반으로 getBoard() 기능 처리");
//        Object[] args = {vo.getSeq()};
//        return spring.queryForMap(BOARD_GET, args);
//    }
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> Spring 기반으로 getBoard() 기능 처리");
        Object[] args = {vo.getSeq()};
        // queryForObject 메소드는 검색 결과가 하나인 쿼리를 위한 메소드.
        // 만약 실행 결과가 두 건 이상이면 Exception 발생
        return (BoardVO) spring.queryForObject(BOARD_GET, args, new BoardRowMapper());
    }

    // 글 목록 검색
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> Spring 기반으로 getBoardList() 기능 처리");
        Object[] args = {vo.getSearchKeyword()};
        return spring.query(BOARD_LIST_TITLE, args, new BoardRowMapper());
    }
}