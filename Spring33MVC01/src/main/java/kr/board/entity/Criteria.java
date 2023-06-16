package kr.board.entity;

import lombok.Data;

// 기준클래스
@Data
public class Criteria { // limit #{pageStart} , #{perPageNum}
  private int page;
  private int perPageNum;
  public Criteria() {
	  this.page=1;
	  this.perPageNum=10;	  
  }
  // 선택한 페지이번호에 해당하는 -> 게시글의 시작번호 구하기
  public int getPageStart() {
	  return (page-1)*perPageNum;
  }  
}
