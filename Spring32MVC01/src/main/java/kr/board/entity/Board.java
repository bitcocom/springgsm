package kr.board.entity;

import java.util.Date;

import lombok.Data;
// Lombok API
// 게시판(번호, 제목, 내용, 작성자, 작성일, 조회수)
@Data
public class Board {
   private int num;
   private String username; // 추가
   private String title;
   private String content;
   private String writer;
   private Date indate;
   private int count;  
   // 답변형 게시판에 추가되는 변수
   private int bgroup; // 원글(부모글)과 답글을 하나로 묶는 역할
   private int bseq; //답글의 순서(오름차순)
   private int blevel; // 답글의 들여쓰기
   private int bdelete; // 게시글의 삭제여부(0:정상--update-->1:삭제)
}
