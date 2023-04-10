package kr.board.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// 게시판 요청(?)을 처리해주는 Controller
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}






