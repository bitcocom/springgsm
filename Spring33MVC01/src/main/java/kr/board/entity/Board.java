package kr.board.entity;

import java.util.Date;

import lombok.Data;
// 게시판(Object) : 번호,제목,내용,작성자,작성일,조회수.......
@Data
public class Board{
  private int num;
  private String username;
  private String title;
  private String content;
  private String writer;
  private Date indate;
  private int count;
  // 답글에 필요한 멤버변수(3가지)
  private int bgroup;// 원글(부모글)과 답글을 하나로 묶을때  
  private int bseq; // 답글의 순서(오름차순)
  private int blevel; // 답글의 들여쓰기
  private int bdelete; // 삭제여부(정상:0-->삭제:1) 
}
