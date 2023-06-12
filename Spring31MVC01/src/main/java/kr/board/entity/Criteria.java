package kr.board.entity;

import lombok.Data;

@Data
public class Criteria {
  private int page;
  private int perPageNum;
  public Criteria() {
	  this.page=1;
	  this.perPageNum=10;// 3
  }
  // 선택한 페이지에 해당하는 게시글의 시작번호 구하기
  // 1page: select * from reply order by bgroup desc, bseq asc limit 0, 10 
  // 2page: select * from reply order by bgroup desc, bseq asc limit 10, 10
  // 3page: select * from reply order by bgroup desc, bseq asc limit 20, 10
  // select * from reply order by bgroup desc, bseq asc 
  // limit #{startNum}, #{perPageNum}
  public int getStartNum() {
	  return (page-1)*perPageNum;
  }  
}
