package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Board;
// BoardMapper interface <----> SQL Mapper XML file
public interface BoardMapper {
  
	// 전체 게시물을 가져오는 메서드 정의
	public List<Board> getLists(); // 추상메서드
    // 게시물을 저장하는 메서드 정의
	public void insert(Board vo);
	//선택한 번호에 해당하는 게시물정보 한개만 가져오는 메서드 정의
    public Board get(int num);
    public void remove(int num);
	
}
