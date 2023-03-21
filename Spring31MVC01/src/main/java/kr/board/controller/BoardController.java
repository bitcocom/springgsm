package kr.board.controller;
// 게시판 요청(?)을 처리해주는 Controller
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // POJO
public class BoardController {
	
  //1.리스트보기 요청이 오면 처리하는 메서드(HandlerMapping)
  @RequestMapping("/list.do")
  public String list() {
	  // 데이터베이스연동(Model)
	  return "board/list";//WEB-INF/views/board/list.jsp
  }	
}