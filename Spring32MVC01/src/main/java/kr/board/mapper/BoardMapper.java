package kr.board.mapper;

import java.util.List;

import kr.board.entity.Board;

public interface BoardMapper {
    // Connection(연결) - root-context.xml
	// CRUD
	public List<Board> getLists(); // 추상메서드
	
}
