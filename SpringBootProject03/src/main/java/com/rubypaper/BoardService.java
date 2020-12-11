package com.rubypaper;

import com.rubypaper.domain.Board;

import java.util.List;

public interface BoardService {
    void insertBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);

    Board getBoard(Board board);

    List<Board> getBoardList();
}
