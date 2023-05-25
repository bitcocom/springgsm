package kr.board.entity;
import lombok.Data;

@Data
public class PageMaker {
   private Criteria cri;
   private int displayPageNum=5;
   private int totalCount;
   private int startPage;
   private int endPage;
   private boolean prev;//true, false 
   private boolean next;//true, false
   
   public void setTotalCount(int totalCount) {
	   this.totalCount=totalCount;
	   makePage();
   }
   public void makePage() {
	 // 1.선택한 페이지의 화면에 보여질 마지막 페이지 번호
	 endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
	 // 2.선택한 페이지의 화면에 보여질 시작 페이지 번호
	 startPage=(endPage-displayPageNum)+1;  
	 if(startPage<=0) startPage=1;
	 // 3.전체 마지막 페이지 계산(31)
	 int tempEndPage=(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
	 // 4.화면에 보여질 마지막 페이지 유효성 체크
	 if(tempEndPage<endPage) {
			endPage=tempEndPage;		
	 }
	// 5.이전페이지 버튼(링크)존재 여부
	 prev=(startPage==1) ? false : true;
	// 6.다음페이지 버튼(링크)존재 여부
	 next=(endPage<tempEndPage)? true : false;	 
   }
}











