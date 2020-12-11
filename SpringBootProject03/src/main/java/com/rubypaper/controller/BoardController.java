package com.rubypaper.controller;

import com.rubypaper.BoardService;
import com.rubypaper.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/insertBoard")
    public String insertBoardView(){
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board){
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board){
        boardService.updateBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping(value = "/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    @RequestMapping(value = "/getBoardList")
    public String getBoardList(Model model) {
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        return "getBoardList";
    }
}
