package edu.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//이름       널?       유형             
//-------- -------- -------------- 
//BID      NOT NULL NUMBER(4)      게시판번호
//BNAME             VARCHAR2(20)      작성자
//BTITLE            VARCHAR2(200)    글제목
//BCONTENT          VARCHAR2(1200) 글내용
//BDATE             DATE                        작성날짜
//BHIT              NUMBER(4)               조회수
//BGROUP            NUMBER(4)           원본글
//BSTEP             NUMBER(4)             세로댓글(계단)
//BINDENT           NUMBER(4)           가로댓글

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
}
