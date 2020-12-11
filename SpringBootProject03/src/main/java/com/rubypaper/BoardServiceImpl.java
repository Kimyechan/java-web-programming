package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public void insertBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard = boardRepository.findById(board.getSeq()).get();
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepository.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getSeq());
    }

    @Override
    public Board getBoard(Board board) {
        return boardRepository.findById(board.getSeq()).get();
    }

    @Override
    public List<Board> getBoardList() {
        return (List<Board>) boardRepository.findAll();
    }

}
