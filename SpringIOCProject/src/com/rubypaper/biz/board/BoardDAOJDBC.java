package com.rubypaper.biz.board;


import com.rubypaper.biz.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 2. DAO (Data Access Object) 클래스
@Repository // Component 기능을 가지고 있다.
public class BoardDAOJDBC implements BoardDAO {
    // JDBC 관련 변수 선언
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // BOARD 테이블 관련 SQL 명령어
    private static final String BOARD_INSERT = "insert into board(seq, title, writer, content) " +
            "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
    private static final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
    private static final String BOARD_UPDATE_CNT = "update board set CNT = CNT + 1 WHERE SEQ = ?";
    private static final String BOARD_DELETE = "delete board where seq = ?";
    private static final String BOARD_GET = "select * from board where seq = ?";
    private static final String BOARD_LIST = "select * from board order by seq desc";
    private static final String BOARD_LIST_TITLE = "select * from board where TITLE like '%'||?||'%' order by seq desc"; // ? 에는 ''가 붙어서 들어가므로 따로 2개 만들어야함.
    private static final String BOARD_LIST_CONTENT = "select * from board where CONTENT like '%'||?||'%' order by seq desc";

    // BOARD 테이블 관련 CRUD 기능의 메소드
    // 글 등록
    @Override
    public void insertBoard(BoardVO vo) {
        System.out.println("===> JDBC 기반으로 insertBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getWriter());
            stmt.setString(3, vo.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 수정
    @Override
    public void updateBoard(BoardVO vo) {
        System.out.println("===> JDBC 기반으로 updateBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setInt(3, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> JDBC 기반으로 deleteBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 상세 조회
    @Override
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> JDBC 기반으로 getBoard() 기능 처리");
        BoardVO board = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();
            if (rs.next()) {
                // 검색 결과 한 건을 BoardVO 객체에 매핑한다.
//                System.out.println(rs.getInt("SEQ") + "번 게시글 내용 : " + rs.getString("CONTENT"));
                board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));

                // 검색 결과가 존재하는 경우 조회수를 증가시킨다.
                stmt = conn.prepareStatement(BOARD_UPDATE_CNT);
                stmt.setInt(1, vo.getSeq());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return board;
    }

    // 글 목록 검색
    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> JDBC 기반으로 getBoardList() 기능 처리");
        // 비어있는 리스트 컬렉션을 생성한다.
        List<BoardVO> boardList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            if (vo.getSearchCondition().equals("TITLE")) {
                stmt = conn.prepareStatement(BOARD_LIST_TITLE);
            } else if (vo.getSearchCondition().equals("CONTENT")) {
                stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
            }
            stmt.setString(1, vo.getSearchKeyword());
//            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                // 검색 결과 한 ROW 당 하나의 BoardVO 객체에 매핑한다.
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));

                // 검색 결과가 매핑된 BoardVO 객체를 리스트 컬렉션에 등록한다.
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        // 검색 결과가 저장된 리스트 컬렉션을 클라이언트로 리턴한다.
        return boardList;
    }
}
