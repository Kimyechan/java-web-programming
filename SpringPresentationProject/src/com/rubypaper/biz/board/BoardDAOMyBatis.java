package com.rubypaper.biz.board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Primary
public class BoardDAOMyBatis implements BoardDAO{
    @Autowired
    private SqlSessionTemplate myBatis;

    // 글 등록
    public void insertBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 insertBoard() 기능 처리");
        myBatis.insert("BoardDAO.insertBoard", vo);
    }
    // 글 수정
    public void updateBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 updateBoard() 기능 처리");
        myBatis.update("BoardDAO.updateBoard", vo);
    }
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 deleteBoard() 기능 처리");
        myBatis.delete("BoardDAO.deleteBoard", vo);
    }
    // 글 상세 조회
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 getBoard() 기능 처리");
        return (BoardVO) myBatis.selectOne("BoardDAO.getBoard", vo); // Object 이므로 명시적 형변환
    }
    // 글 목록 검색
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> MyBatis 기반으로 getBoardList() 기능 처리");
        return (List<BoardVO>) myBatis.selectList("BoardDAO.getBoardList", vo);
    }
}
