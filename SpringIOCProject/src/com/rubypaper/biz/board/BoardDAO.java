package com.rubypaper.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rubypaper.biz.common.JDBCUtil;

// DAO(Data Access Object) Ŭ����
public class BoardDAO {
	// JDBC ���� ���� ����
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// BOARD ���̺� ���� SQL ��ɾ�
	private static final String BOARD_INSERT     = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " + 
											       "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_UPDATE     = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
	private static final String BOARD_DELETE     = "DELETE BOARD WHERE SEQ=?";
	private static final String BOARD_GET        = "SELECT * FROM BOARD WHERE SEQ=?";
	private static final String BOARD_LIST_TITLE   = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
	private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";
	
	// BOARD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	public void insertBoard(BoardVO vo) {
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
	
	// �� ����
	public void updateBoard(BoardVO vo) {
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
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
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
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				// �˻� ��� �� ���� BoardVO ��ü�� �����Ѵ�.
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				// �˻� ����� �����ϴ� ��� ��ȸ���� ������Ų��.
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
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		// ����ִ� ����Ʈ �÷����� �����Ѵ�. 
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_TITLE);
			} else if(vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
			}
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();
			while(rs.next()) {
				// �˻� ��� �� ROW�� �ϳ��� BoardVO ��ü�� �����Ѵ�.
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				// �˻� ����� ���ε� BoardVO ��ü�� ����Ʈ �÷��ǿ� ����Ѵ�. 
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		// �˻� ����� ����� ����Ʈ �÷����� Ŭ���̾�Ʈ�� �����Ѵ�.
		return boardList;
	}
}




