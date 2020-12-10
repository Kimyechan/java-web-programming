package com.rubypaper.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private Long id;
    private String password;
    private String name;
    private String role;

    // mappedBy는 양방향 매핑에서 연관관계의 주인이 아닌 쪽 변수에 선언한다. 속성 값은 연관관계 주인 변수 이름이다.
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

}
