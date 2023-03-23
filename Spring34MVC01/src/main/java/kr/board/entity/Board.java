package kr.board.entity;

import java.util.Date;

import lombok.Data;
// Lombok API : http://mvnrepository.com
@Data
public class Board {

	private int num; // 번호
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private Date indate; // 작성일 java.util.Date
	private int count; // 조회수
	
}
