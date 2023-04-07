package kr.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
   
	@Autowired
	private BoardMapper mapper;
	// /list.do 요청이 오면 처리하는 메서드 정의
	// HandlerMapping
	@RequestMapping("/list.do")
	public String list(Model model) {
		// Controller에서 View로 데이터를 넘기는 방법
		List<Board> list=mapper.getList();
		model.addAttribute("list", list);
		return "board/list"; //->/WEB-INF/views/board/list.jsp:ViewResolver
	}	
	@RequestMapping("/writefrm")
	public String writefrm() {
	
		return "board/write"; // write.jsp
	}
	
	
}
