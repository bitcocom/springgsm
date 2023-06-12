package kr.board.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// 게시판 요청(?)을 처리해주는 Controller
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Board;
import kr.board.entity.Criteria;
import kr.board.entity.PageMaker;
import kr.board.mapper.BoardMapper;

@Controller // POJO
public class BoardController {
	
  @Autowired	
  private BoardMapper mapper;	
  //1.리스트보기 요청이 오면 처리하는 메서드(HandlerMapping)
  @RequestMapping("/list.do")
  public String list(Criteria cri,Model model) {	  
	  List<Board> list=mapper.getLists(cri);	  
	  model.addAttribute("list", list);// 객체바인딩
	  // PageMaker객체 생성
	  PageMaker pm=new PageMaker();
	  pm.setCri(cri);
	  pm.setTotalCount(mapper.totalCount());
	  model.addAttribute("pm", pm);		  
	  return "board/list";//WEB-INF/views/board/list.jsp
  }	
  
  @RequestMapping("/registerfrm.do")
  public String registerfrm() {
	  return "board/register"; // register.jsp
  }
  
  @RequestMapping("/register.do")  // title, content, writer
  public String register(Board vo) { // 폼에서 넘어온 파라메터 수집(VO)
	  mapper.register(vo);	 
	  // 글 등록후에는 다시 리스트페이지로(list.do) 이동
	  return "redirect:/list.do";
  }
  
  @RequestMapping("/get.do") // ?num=10
  public String get(int num, Model model) {
	  Board vo=mapper.get(num);
	  model.addAttribute("vo", vo); 
	  // 조회수 누적
	   mapper.count(num);
	  return "board/get"; // get.jsp : forward
  }
  
  @RequestMapping("/remove.do") // ?num=10
  public String remove(int num) {
	  mapper.remove(num);
	  // 삭제성공후 다시 리스트페이지로 이동 : redirect
	  return "redirect:/list.do";
  }
  @GetMapping("/update.do") // ?num=10
  public String update(int num, Model model) {
	  Board vo=mapper.get(num);
	  model.addAttribute("vo", vo);
	  return "board/update"; // update.jsp
  }
  @PostMapping("/update.do") // num, title, content
  public String update(Board vo) {
	  mapper.update(vo);
	  // 수정 성공 후 다시 리스트페이지로 이동(/list.do)
	  // 수정 성공 후 다시 상세보기페이지로 이동(/get.do?num=10)
	  //return "redirect:/list.do";
	  return "redirect:/get.do?num="+vo.getNum();
  }
  @GetMapping("/reply.do")
  public String reply(int num, Model model) { // 부모의 게시글 번호
	  Board pvo=mapper.get(num); // pvo(부모의 정보)
	  model.addAttribute("pvo", pvo);
	  return "board/reply";	// reply.jsp  
  }
  @PostMapping("/reply.do")
  public String reply(Board vo) {//num(부모의번호), username(아이디), title, content, writer
	  // 부모의 bgroup, bseq, blevel의 값을 기준으로 답글의 bgroup, bseq, blevel
	  // 1.부모글의 정보 가져오기
	  Board pvo=mapper.get(vo.getNum());
	  // 2.부모의 bgroup의 값을 답글의 bgroup으로 지정
	  vo.setBgroup(pvo.getBgroup());
	  // 3.부모의 bseq에 +1 해서 답글의 bseq에 저장
	  vo.setBseq(pvo.getBseq()+1);
	  // 4.부모의 blevel에 +1 해서 답글의 blevel에 저장
	  vo.setBlevel(pvo.getBlevel()+1);
	  // 5.부모의 bgroup과 같고/ 부모의 bseq보다 큰 답글의 bseq값을 모두 1씩 증가
	  mapper.replyUpdate(pvo);
	  // 6. 답글저장
	  mapper.replyInsert(vo);
	  return "redirect:/list.do";
  }
}











