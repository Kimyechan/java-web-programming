package com.rubypaper.biz.board;

import lombok.Data;

import java.sql.Date;

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
