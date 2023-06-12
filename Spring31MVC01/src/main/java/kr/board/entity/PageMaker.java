package kr.board.entity;

import lombok.Data;

@Data
public class PageMaker {
  private Criteria cri;
  private int totalCount;
  private int displayPageNum=5;
  private int startPage; // 선택한 페이지에 해당하는 시작페이지 번호
  private int endPage; // 선택한 페이지에 해당하는 끝페이지 번호 
  private boolean prev; // true
  private boolean next; // true  
}
