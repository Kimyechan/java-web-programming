package com.rubypaper.biz.board;

import com.rubypaper.biz.common.JDBCUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component("boardDAO")
public class BoardDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " +
            "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
    private static final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
    private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
    private static final String BOARD_DELETE = "DELETE BOARD WHERE SEQ=?";
    private static final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
    private static final String BOARD_LIST_TITLE = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
    private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";

    public BoardDAO() {
    }

    public void insertBoard(BoardVO vo) {
        System.out.println("====> JDBC 기반 insertBoard");
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

    public void updateBoard(BoardVO vo) {
        System.out.println("====> JDBC 기반 updateBoard");
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

    public void deleteBoard(BoardVO vo) {
        System.out.println("====> JDBC 기반 deleteBoard");
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

    public BoardVO getBoard(BoardVO vo) {
        System.out.println("====> JDBC 기반 getBoard");
        BoardVO board = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();
            if (rs.next()) {
                board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));

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

    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("====> JDBC 기반 getBoardList");
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        try {
            conn = JDBCUtil.getConnection();
            if (vo.getSearchCondition().equals("TITLE")) {
                stmt = conn.prepareStatement(BOARD_LIST_TITLE);
            } else if (vo.getSearchCondition().equals("CONTENT")) {
                stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
            }
            stmt.setString(1, vo.getSearchKeyword());
            rs = stmt.executeQuery();
            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return boardList;
    }
}




