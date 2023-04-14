package kr.board.mapper;

import java.util.List;

import kr.board.entity.Board;

public interface BoardMapper { // BoardMapper.xml
   // DB연결(root-context.xml)
   // 게시판 전체 리스트를 가져오는 메서드
   public List<Board> getList();
   // 게시판 글 등록 메서드
   public void write(Board vo);
   // 선택한 게시물정보 1개를 가져오는 메서드
   public Board get(int num);
}
