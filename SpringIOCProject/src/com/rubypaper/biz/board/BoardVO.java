package com.rubypaper.biz.board;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

// VO(Value Object) Ŭ����
/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
@Data
public class BoardVO {
    private Integer seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Integer cnt;
    private String searchCondition;
    private String searchKeyword;
}
