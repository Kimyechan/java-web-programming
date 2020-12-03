package com.rubypaper.biz.board;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

// 1. VO(Value Object) 클래스
@Data
public class BoardVO {
    // 테이블의 컬럼 이름(데이터 타입까지)과 동일한 멤버변수를 private 으로 선언한다.
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private int cnt;
}