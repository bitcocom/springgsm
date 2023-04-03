package kr.board.mapper;

import java.util.List;

import kr.board.entity.Board;

public interface BoardMapper {

	// 게시판 전체리스트 가져오기
	public List<Board> getLists();
	
}
