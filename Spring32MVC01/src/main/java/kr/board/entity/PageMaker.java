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
	   
   }
}
