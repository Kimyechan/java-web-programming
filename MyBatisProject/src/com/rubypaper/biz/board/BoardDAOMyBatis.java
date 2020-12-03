package com.rubypaper.biz.board;

import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 2. DAO (Data Access Object) 클래스
public class BoardDAOMyBatis {
    private SqlSession mybatis;

    // 글 등록
    public void insertBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 insertBoard() 기능 처리");
        mybatis.insert("insertBoard", vo);
    }

    // 글 수정
    public void updateBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 updateBoard() 기능 처리");
        mybatis.update("updateBoard", vo);
    }

    public void deleteBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 deleteBoard() 기능 처리");
        mybatis.delete("deleteBoard", vo);
    }

    // 글 상세 조회
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 getBoard() 기능 처리");
        return (BoardVO) mybatis.selectOne("getBoard", vo);
    }

    // 글 목록 검색
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 getBoardList() 기능 처리");
        // 비어있는 리스트 컬렉션을 생성한다.
        return mybatis.selectList("getBoardList");
    }
}
