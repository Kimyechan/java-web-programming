package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class RelationMappingTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

//    @BeforeEach
    public void testManyToOneInsert() {
        Member member1 = new Member();
        member1.setId(1L);
        member1.setName("둘리");
//        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setId(2L);
        member2.setName("도우너");
//        memberRepository.save(member2);

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.addMember(member1); // 둘리가 등록한 게시 글
            board.setTitle("둘리가 등록한 게시글: " + i);
            board.setCreateDate(new Date());
//            boardRepository.save(board);
        }
        memberRepository.save(member1);
        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.addMember(member2); // 둘리가 등록한 게시 글
            board.setTitle("도우너가 등록한 게시글: " + i);
            board.setCreateDate(new Date());
//            boardRepository.save(board);
        }
        memberRepository.save(member2);
    }

    @Test
    public void testManyToOneSelect() {
        Board board = boardRepository.findById(5L).get();
        System.out.println(board.getMember().getName());
    }

    @Test
    public void testOneToManySelect() {
        Member member = memberRepository.findById(1L).get();
        System.out.println(member.getName());
        List<Board> boardList = member.getBoardList();
        for (Board board: boardList) {
            System.out.println(board.getTitle());
        }
    }

    @Test
    public void testCascadeDelete() {
        memberRepository.deleteById(1L);
    }
}
