package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;
import kr.board.entity.Member;

public interface BoardMapper {

	// 게시판 전체리스트 가져오기
	public List<Board> getLists();
	//게시판 글쓰기 메서드
	public void register(Board vo);
	// 선택한 번호에 해당하는 게시글 한개(Board) 가져오기
	public Board get(int num);
	// 선택한 번호에 해당하는 게시글을 삭제하기
	public void remove(int num);
	// 선택한 번호에 해당하는 게시글을 수정하기
	public void update(Board vo);
	// 선택한 게시물을 1씩 증가하기
	@Update("update reply set count=count+1 where num=#{num}")
	public void count(int num);
	
	public Member login(Member vo);
}




