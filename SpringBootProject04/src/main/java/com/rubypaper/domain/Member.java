package com.rubypaper.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
public class Member {
    @Id
    // 아이디를 자동으로 증가시킬 수는 없다.
    private String id;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING) // 문자?, 숫자?
    private Role role;
    private boolean enabled;
}
