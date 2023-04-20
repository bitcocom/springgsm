package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import kr.board.entity.Board;

public interface BoardMapper {
    // Connection(연결) - root-context.xml
	// CRUD
	public List<Board> getLists(); // 추상메서드
	public void write(Board vo);
	public Board get(int num);
	
	@Delete("delete from board where num=#{num}")
	public void remove(int num);
	
	public void update(Board vo);
}
