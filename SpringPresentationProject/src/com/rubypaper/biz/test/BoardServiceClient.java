package com.rubypaper.biz.test;

import com.rubypaper.biz.board.BoardService;
import com.rubypaper.biz.board.BoardVO;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        String[] configuration = {"business-layer.xml", "business-transaction.xml"};
//        GenericXmlApplicationContext container =
//                new GenericXmlApplicationContext(configuration);
        GenericXmlApplicationContext container =
                new GenericXmlApplicationContext("business-*.xml");

        BoardService boardService = container.getBean(BoardService.class);
        if(boardService != null) {
            System.out.println(boardService + " : Lookup 성공");
        }

        BoardVO voInsert = new BoardVO();
        voInsert.setSeq(102);
        voInsert.setTitle("Spring");
        voInsert.setWriter("테스터");
        voInsert.setContent("Spring");

        boardService.insertBoard(voInsert);
        boardService.insertBoard(voInsert);

        BoardVO vo = new BoardVO();
        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        List<BoardVO> boardList = boardService.getBoardList(vo);
        System.out.println("[ BOARD LIST ]");
        for ( BoardVO board : boardList ) {
            System.out.println("---> " + board.toString());
        }

        BoardVO voGetBoard = new BoardVO();
        voGetBoard.setSeq(4);
        BoardVO board = boardService.getBoard(voGetBoard);
        System.out.println(board);
        // 예외처리 AOP
       /* BoardVO voInsert = new BoardVO();
        voInsert.setSeq(0);
        boardService.insertBoard(voInsert);*/

        container.close();
    }
}
