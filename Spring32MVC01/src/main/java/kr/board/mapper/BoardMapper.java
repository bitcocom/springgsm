package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;
import kr.board.entity.Member;

public interface BoardMapper {
    // Connection(연결) - root-context.xml
	// CRUD
	public List<Board> getLists(); // 추상메서드
	public void write(Board vo);
	public Board get(int num);
	
	@Delete("delete from reboard where num=#{num}")
	public void remove(int num);
	
	public void update(Board vo);
	
	@Update("update reboard set count=count+1 where num=#{num}")
    public void count(int num);	
	
	public Member login(Member vo);
}




