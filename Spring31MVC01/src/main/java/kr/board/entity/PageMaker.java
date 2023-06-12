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
  // 전체게시글의 수를 저장하는 메서드
  public void setTotalCount(int totalCount) {
	  this.totalCount=totalCount;
	  makePage();
  }
  // 페이지리스트를 출력하기 위한 계산 메서드
  public void makePage() {
	  //1. 선택한 페이지에 해당하는 끝페이지 번호구하기
	  endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
	  //2. 선택한 페이지에 해당하는 시작페이지 번호구하기
	  startPage=(endPage-displayPageNum)+1;		
      //3. 전체 게시물의 마지막 페이지 번호
	  int tempPageNum=(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
	  //4. endPage의 유효성 검사
	  if(endPage>tempPageNum) {
		  endPage=tempPageNum;
	  }
	  //5.이전 버튼이 나오는 여부
	   prev=(startPage!=1) ? true : false;
	  //6.다음 버튼이 나오는 여부  
	   next=(endPage<tempPageNum) ? true : false;
  }
}
