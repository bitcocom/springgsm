package kr.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Board;

@Controller
public class BoardController {
   
	// /list.do 요청이 오면 처리하는 메서드 정의
	@RequestMapping("/list.do")
	public String list(Model model) {
		// Controller에서 View로 데이터를 넘기는 방법
		Board vo=new Board();
		vo.setNum(1);
		vo.setTitle("게시판 출력하기");
		vo.setWriter("이름");
		vo.setIndate(new Date());
		vo.setCount(0);
		List<Board> list=new ArrayList<>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		model.addAttribute("list", list);
		return "board/list"; //->/WEB-INF/views/board/list.jsp:ViewResolver
	}	
	@RequestMapping("/register.do")
    public String register() {
		
		return "";
	}
	
}
