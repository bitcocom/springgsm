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
import kr.board.mapper.BoardMapper;

@Controller // POJO
public class BoardController {
	
  @Autowired	
  private BoardMapper mapper;	
  //1.리스트보기 요청이 오면 처리하는 메서드(HandlerMapping)
  @RequestMapping("/list.do")
  public String list(Model model) {	  
	  List<Board> list=mapper.getLists();	  
	  model.addAttribute("list", list);// 객체바인딩
	  
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
  
}











