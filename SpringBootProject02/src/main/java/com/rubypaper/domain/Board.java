package com.rubypaper.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@ToString(exclude = "member")
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
//    private String writer;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

    // @ManyToOne은 N : 1 관계를 매핑하는 어노테이션
    // 게시글(N) : 회원(1)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", nullable = false) // FK로 사용할 컬럼을 지정한다
    private Member member;

    public void addMember(Member member) {
        this.member = member;
        member.getBoardList().add(this);
    }
}
