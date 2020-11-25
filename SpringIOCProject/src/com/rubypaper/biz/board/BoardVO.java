package com.rubypaper.board;

import java.sql.Date;

import lombok.Data;

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
	// ���̺��� �÷� �̸�(������ Ÿ�Ա���)�� ������ ��������� private���� �����Ѵ�. 
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	
	// private ��� ������ �����ϴ� public Getter/Setter �޼ҵ带 �ۼ��Ѵ�.
	// ���� Ű(Alt + Shift + S)�� �̿��Ѵ�. 
}
