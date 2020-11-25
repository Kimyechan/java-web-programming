package com.rubypaper.biz.test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
    public static void main(String[] args) {
        GenericXmlApplicationContext container =
                new GenericXmlApplicationContext("business-layer.xml");

//        BoardService boardService = container.getBean(BoardService.class);
//        if(boardService != null) {
//            System.out.println(boardService + " : Lookup 성공");
//        }
//
//        BoardVO vo = new BoardVO();
//        vo.setSearchCondition("TITLE");
//        vo.setSearchKeyword("");
//        List<BoardVO> boardList = boardService.getBoardList(vo);
//        System.out.println("[ BOARD LIST ]");
//        for ( BoardVO board : boardList ) {
//            System.out.println("---> " + board.toString());
//        }
//
//        container.close();
    }
}
