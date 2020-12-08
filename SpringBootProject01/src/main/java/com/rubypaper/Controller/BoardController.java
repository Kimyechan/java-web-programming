package com.rubypaper.Controller;

import com.rubypaper.domain.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BoardController {
    public BoardController() {
        System.out.println("===> BoardController created");
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
//    @ResponseBody
    public String hello(String name) {
        return "hello : " + name;
    }

    @GetMapping("/getBoard")
    public BoardVO getBoard(){
        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("");
        board.setWriter("");
        board.setContent("");
        board.setRegDate(new Date());
        board.setCnt(0);

        return board;
    }

    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BoardVO board = new BoardVO();
            board.setSeq(i);
            board.setTitle("");
            board.setWriter("");
            board.setContent("");
            board.setRegDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }

}
