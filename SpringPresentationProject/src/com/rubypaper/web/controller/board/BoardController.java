package com.rubypaper.web.controller.board;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardDAOJDBC;
import com.rubypaper.biz.board.BoardService;
import com.rubypaper.biz.board.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

// @SessionAttributes를 이용하면 특정 이름으로 Model에 저장된 데이터를 세션에도 등록되도록 한다.
// 따라서 getBoard 메소드에서 Model에 "board"라는 이름으로 BoardVO 객체를 Model에 저장하면
// 세션에도 "board"라는 이름으로 BoardVO 객체가 등록되는 것이다.
@SessionAttributes({"board", "aaa", "bbb", "ccc"})
@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/dataTransform.do")
    @ResponseBody // HTTP 응답 프로토콜 BODY 에 JSON형태로 담을 수 있다(http request header의 accept type을 정하면 정한 타입으로 보내준다. xml도 가능
    public List<BoardVO> dataTransform(BoardVO vo) {
        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        return boardService.getBoardList(vo);
    }

    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, Model model) {
        System.out.println("상세 화면에서의 BoardVO 객체 정보");
        System.out.println(vo.toString());
        BoardVO board = boardService.getBoard(vo);
        // Model에 저장한 데이터는 자동으로 request에 등록된다.
        model.addAttribute("board", board);
        return "getBoard";
    }
    @RequestMapping("/getBoardList.do")
    public String getBoardList(BoardVO vo, Model model) {
        // Null Check
        if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
        if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");

        // 절대 검색 결과는 세션에 저장해서는 안된다. 검색 결과는 request에 등록한다.
        // ModelAndView나 Model 객체에 검색 결과를 등록하면 자동으로 세션이 아닌 request에 등록해준다
        model.addAttribute("boardList", boardService.getBoardList(vo)); // model 정보
        model.addAttribute("search", vo); // model 정보
        return "getBoardList"; // viewName
    }

    @RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
    public String insertBoardView(BoardVO vo) {
        // 매개변수로 받은 VO 객체는 자동을 request 내장객체에 등록된다
        // 따라서 최종적으로 실행되는 화면(JSP)에서 EL을 이용하여 값을 뿌릴 수 있다.
        vo.setTitle("200글자 미만으로..");
        vo.setWriter("테스터");
        vo.setContent("200글자 미만으로 적어주세요..");
        return "insertBoard";
    }

    @RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
    public String insertBoard(HttpServletRequest request, BoardVO vo) throws IOException {
        // 파일 업로드 처리
        System.out.println(request.getCharacterEncoding());
        System.out.println(request.getRequestURI());
        System.out.println(vo);
        MultipartFile uploadFile = vo.getUploadFile();
        if(!uploadFile.isEmpty()) { // 파일 업로드 정보가 하나라도 있으면...
            uploadFile.transferTo(new File("/Users/kimyechan/Downloads/upload_files/" + uploadFile.getOriginalFilename()));
        }

        boardService.insertBoard(vo);
        return "forward:getBoardList.do";
    }

    // 글 수정
    // @ModelAttribute는 세션에 "board"라는 이름으로 데이터가 등록되어있다면 그 객체를 vo 변수에 바인딩해라... 라는 의미이다.
    @RequestMapping("/updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO vo) {
        System.out.println("수정 처리에서의 BoardVO 객체 정보");
        System.out.println(vo.toString());
        boardService.updateBoard(vo);

        return "forward:getBoardList.do";
    }
    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo) {
        boardService.deleteBoard(vo);

        return "forward:getBoardList.do";
    }

    /*@RequestMapping("/deleteBoard.do")
    public String deleteBoard(@RequestParam(value = "seq", defaultValue = "1", required = true) int boardSeq, BoardDAO boardDAO) {
        System.out.println(boardSeq);
//        boardDAO.deleteBoard(vo);

        return "forward:getBoardList.do";
    }*/
}
