package com.rubypaper.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
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
    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID") // FK로 사용할 컬럼을 지정한다
    private Member member;
}
