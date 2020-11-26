package com.rubypaper.biz.test;

import com.rubypaper.biz.board.BoardService;
import com.rubypaper.biz.board.BoardVO;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        GenericXmlApplicationContext container =
                new GenericXmlApplicationContext("business-layer.xml");

        BoardService boardService = container.getBean(BoardService.class);
        if(boardService != null) {
            System.out.println(boardService + " : Lookup 성공");
        }

        BoardVO vo = new BoardVO();
        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        List<BoardVO> boardList = boardService.getBoardList(vo);
        System.out.println("[ BOARD LIST ]");
        for ( BoardVO board : boardList ) {
            System.out.println("---> " + board.toString());
        }

        // 예외처리 AOP
        /*BoardVO voInsert = new BoardVO();
        voInsert.setSeq(0);
        boardService.insertBoard(voInsert);*/

        container.close();
    }
}
