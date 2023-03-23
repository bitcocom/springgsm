package kr.board.entity;

import java.util.Date;

import lombok.Data;
// Lombok API
// 게시판(번호, 제목, 내용, 작성자, 작성일, 조회수)
@Data
public class Board {
   private int num;
   private String title;
   private String content;
   private String writer;
   private Date indate;
   private int count;     
}
