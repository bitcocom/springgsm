package kr.board.mapper;

import java.util.List;

import kr.board.entity.Board;

public interface BoardMapper {

	// 게시판 전체리스트 가져오기
	public List<Board> getLists();
	//게시판 글쓰기 메서드
	public void register(Board vo);
	// 선택한 번호에 해당하는 게시글 한개(Board) 가져오기
	public Board get(int num);
}