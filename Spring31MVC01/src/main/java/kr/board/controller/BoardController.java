package kr.board.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 게시판 요청(?)을 처리해주는 Controller
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Board;

@Controller // POJO
public class BoardController {
	
  //1.리스트보기 요청이 오면 처리하는 메서드(HandlerMapping)
  @RequestMapping("/list.do")
  public String list(Model model) {
	  Board vo1=new Board(1, "스프링 연습", "스프링 연습", "관리자", new Date(), 0);
	  Board vo2=new Board(2, "스프링 연습", "스프링 연습", "박매일", new Date(), 0);
	  Board vo3=new Board(3, "스프링 연습", "스프링 연습", "홍길동", new Date(), 0);
	  List<Board> list=new ArrayList<Board>();
	  list.add(vo1);
	  list.add(vo2);
	  list.add(vo3);
	  model.addAttribute("list", list);
	  
	  return "board/list";//WEB-INF/views/board/list.jsp
  }	
}