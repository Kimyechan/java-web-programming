package test;

import com.rubypaper.biz.board.BoardDAOMyBatis;
import com.rubypaper.biz.board.BoardVO;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        BoardVO vo = new BoardVO();
        vo.setTitle("MyBATIS 제목");
        vo.setWriter("테스터");
        vo.setContent("MyBatis 내용.......");

        BoardDAOMyBatis boardDAO = new BoardDAOMyBatis();
        boardDAO.insertBoard(vo);

        List<BoardVO> boardVOList = boardDAO.getBoardList(vo);
        for(BoardVO board : boardVOList) {
            System.out.println(" ---------> " + board.toString());
        }
    }
}
