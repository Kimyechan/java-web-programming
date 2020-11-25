package com.rubypaper.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 4. Service 구현 클래스 (비지니스 로직 처리)
@Service
public class BoardServiceImpl implements BoardService {
    BoardDAO boardDAO;

//    public BoardServiceImpl() {
//        System.out.println("=====> BoardServiceImpl 생성");
//    }

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

//    public void setBoardDAO(BoardDAO boardDAO) {
//        this.boardDAO = boardDAO;
//    }

    @Override
    public void insertBoard(BoardVO vo) {
        boardDAO.insertBoard(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        return boardDAO.getBoardList(vo);
    }
}
