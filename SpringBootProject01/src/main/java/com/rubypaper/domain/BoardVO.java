package com.rubypaper.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate = new Date();
    private int cnt;
}
