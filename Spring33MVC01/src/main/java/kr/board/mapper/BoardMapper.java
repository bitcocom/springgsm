package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;
import kr.board.entity.Criteria;
import kr.board.entity.Member;

public interface BoardMapper { // BoardMapper.xml
   // DB연결(root-context.xml)
   // 게시판 전체 리스트를 가져오는 메서드
   public List<Board> getList(Criteria cri);
   // 게시판 글 등록 메서드
   public void write(Board vo);
   // 선택한 게시물정보 1개를 가져오는 메서드
   public Board get(int num);
   // 선택한 게시물을 삭제하는 메서드
   @Update("update reply set bdelete=1 where num=#{num}")
   public void remove(int num);
   public void update(Board vo);
   // 조회수 증가 메서드
   @Update("update reply set count=count+1 where num=#{num}")
   public void count(int num);   
   // 회원 로그인처리
   public Member login(Member vo);
   // 답글의 bseq값을 모두 1씩 증가
   public void replyUpdate(Board pvo); // bgroup, bseq
   //답글 저장
   public void replyInsert(Board vo);
   
   @Select("select count(*) from reply")
   public int totalCount();
}




