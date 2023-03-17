package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
   
	// /list.do 요청이 오면 처리하는 메서드 정의
	@RequestMapping("/list.do")
	public String list() {
		// 게시판리스트를 DB에서 가져오기...
		return "board/list"; //->/WEB-INF/views/board/list.jsp:ViewResolver
	}	
	@RequestMapping("/register.do")
    public String register() {
		
		return "";
	}
	
}
