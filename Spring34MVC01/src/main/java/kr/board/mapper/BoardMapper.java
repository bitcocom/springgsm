package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Board;
// BoardMapper interface <----> SQL Mapper XML file
public interface BoardMapper {
  
	// 전체 게시물을 가져오는 메서드 정의
	public List<Board> getLists(); // 추상메서드
	
}
