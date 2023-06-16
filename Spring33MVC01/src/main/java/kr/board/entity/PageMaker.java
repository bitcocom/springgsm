package kr.board.entity;

import lombok.Data;

@Data
public class PageMaker {
  private Criteria cri;
  private int totalCount;
  private int displayPageNum=10;
  private int startPage;
  private int endPage;
  private boolean prev; // true
  private boolean next; // true 
  // 전체게시글의 수를 설정하는 메서드
  public void setTotalCount(int totalCount) {
	  this.totalCount=totalCount;
	  makePage();
  }
  // 페이지 리스트를 출력하기 위한 계산 메서드
  public void makePage() {
	  
  }
}
