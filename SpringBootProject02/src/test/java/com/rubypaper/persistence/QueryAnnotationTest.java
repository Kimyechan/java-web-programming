package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {

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
    public void testQueryAnnotationTest1() {
        List<Board> boardList = boardRepository.queryAnnotationTest1("테스트 제목: 17");
        System.out.println("검색 결과");
        for (Board board: boardList
             ) {
            System.out.println("---> " + board.toString());
        }
    }

//    @Test
//    public void testQueryAnnotationTest2() {
//        List<Object[]> boardList = boardRepository.queryAnnotationTest2("테스트 제목: 17");
//        System.out.println("검색 결과");
//        for (Object[] board: boardList
//        ) {
//            System.out.println("---> " + Arrays.toString(board));
//        }
//    }

    @Test
    public void testQueryAnnotationTest3() {
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
        List<Board> boardList = boardRepository.queryAnnotationTest3(pageable);
        System.out.println("검색 결과");
        for (Board board: boardList
        ) {
            System.out.println("---> " + board.toString());
        }
    }

}