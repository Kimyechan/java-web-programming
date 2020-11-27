package com.rubypaper.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService") // Component 기능도 가지고 있다.
public class BoardServiceImpl implements BoardService {
    private BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public BoardServiceImpl() {
        System.out.println("===> BoardServiceImpl 생성");
    }

    @Override
    public void insertBoard(BoardVO vo) {
//        if (vo.getSeq() == 0) {
//            throw new IllegalArgumentException();
//        }
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
