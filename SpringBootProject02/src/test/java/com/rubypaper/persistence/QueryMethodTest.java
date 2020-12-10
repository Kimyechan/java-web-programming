package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private BoardRepository boardRepository;

//    @BeforeEach
//    public void dataPrepare() {
//        for (int i = 0; i <= 200; i++) {
//            Board board = new Board();
//            board.setTitle("테스트 제목: " + i);
//            board.setWriter("테스터");
//            board.setContent("테스트 내용 " + i);
//            board.setCreateDate(new Date());
//            board.setCnt(0L);
//            boardRepository.save(board);
//        }
//    }

    @Test
    public void testFindByTitle() {
        List<Board> boardList = boardRepository.findByTitle("테스트 제목: 10");
        for (Board board : boardList
             ) {
            System.out.println(" ----> " + board.toString());
        }
    }

    @Test
    public void testFindByContentContaining() {
        List<Board> boardList = boardRepository.findByContentContaining("17");
        for (Board board : boardList
        ) {
            System.out.println(" ----> " + board.toString());
        }
    }

    @Test
    public void findByTitleContainingOrContentContaining() {
        List<Board> boardList = boardRepository.findByTitleContainingOrContentContaining("17", "17");
        for (Board board : boardList
        ) {
            System.out.println(" ----> " + board.toString());
        }
    }

    @Test
    public void findByContentContainingOrderBySeqDesc() {
        List<Board> boardList = boardRepository.findByContentContainingOrderBySeqDesc("17");
        for (Board board : boardList
        ) {
            System.out.println(" ----> " + board.toString());
        }
    }

    @Test
    public void findByTitleContaining() {
        Pageable pageable = PageRequest.of(3, 5, Sort.Direction.DESC, "seq");
        Page<Board> pageInfo = boardRepository.findByTitleContaining("17", pageable);

        System.out.println("PAGE SIZE : " + pageInfo.getSize());
        System.out.println("Total Pages : " + pageInfo.getTotalPages());
        System.out.println("Total Count : " + pageInfo.getTotalElements());
        System.out.println("Next Page : " + pageInfo.nextPageable());

        List<Board> boardList = pageInfo.getContent();
        for (Board board : boardList
        ) {
            System.out.println(" ----> " + board.toString());
        }
    }

}