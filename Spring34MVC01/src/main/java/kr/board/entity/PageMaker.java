package kr.board.entity;

import lombok.Data;

@Data
public class PageMaker { // ◀ 1 2 3 4 5 ▶
	private Criteria cri;
	private int totalCount; // 전체게시글의수
	private int displayPageNum=5;
	private int startPage;
	private int endPage;
	private boolean prev; // 이전버튼(true, false)
    private boolean next; // 다음버튼(true, false)
    
    public void pageMaker() {
    	
    }
}
