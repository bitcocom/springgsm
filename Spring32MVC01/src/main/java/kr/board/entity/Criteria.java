package kr.board.entity;

import lombok.Data;
// 페이징 처리에 기준클래스
@Data
public class Criteria {
  private int page;
  private int perPageNum; 
  // 검색에 필요한 변수
  private String type;
  private String keyword;
  
  // 초기화
  public Criteria() {
	  page=1;
	  perPageNum=3;
  }
  // 선택한 페이지에 해당하는 게시글의 시작번호를 구하기
  // 1page: 0~perPageNum, 2page: 10~perPageNum, 3page: 20~perPageNum 
  public int getPageStart() {
	 return (page-1)*perPageNum; 	  
  }
}
