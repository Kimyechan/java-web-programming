package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testDeleteBoard() {
        boardRepository.deleteById(1L);

    }
    @Test
    public void testUpdateBoard() {
        // 수정할 엔티티를 검색한다. 검색을 해야 1차 캐시에 엔티티가 등록되고, 이 상태가 영속 상태이다.
        Board board = boardRepository.findById(1L).get();
        board.setTitle("---------수정----------");
        // CrudRepository 에 있는 save() 메소드는 merge() 메소드와 유사한다
        boardRepository.save(board);
    }
    @Test
    public void testGetBoard() {
        Board board = boardRepository.findById(1L).get();
        System.out.println(board.toString());
    }

    @Test
    public void testInsertBoard() {
        Board board = new Board();
        board.setTitle("Boot JPA 테스트");

        boardRepository.save(board);
    }

    @Test
    public void testGetBoardList() {
        List<Board> boardList = (List<Board>) boardRepository.findAll();
    }

}