package kr.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Board;

// POJO
@Controller
public class BoardController {
	// http://127.0.0.1:8081/s32/list
    //게시판리스트 보기(/list)--->list()
	@RequestMapping("/list")
	public String list(Model model) {
		// 여기에 List<Board>구조로 게시물 3개를 저장하고
		// list.jsp로 넘기자
		Board vo=new Board();
		vo.setNum(1);
		vo.setTitle("게시판 연습");
		vo.setWriter("박매일");
		vo.setIndate(new Date());
		vo.setCount(0);
		List<Board> list=new ArrayList<>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		// 객체바인딩
	    model.addAttribute("list", list);		
		return "board/list"; // EL(표현식,출력식) : ${list}
	}
}
