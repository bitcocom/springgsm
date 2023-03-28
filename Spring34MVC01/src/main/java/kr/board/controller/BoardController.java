package kr.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Board;

// Controller
@Controller
public class BoardController { // new BoardController();

	// 요청-->처리메서드 : 핸들러매핑(HandlerMapping)
	// [게시판리스트보기 요청]이 오면 처리하는 [메서드]를 만들자
	@RequestMapping("/list.do")
	public String list(Model model) {
		Board vo=new Board();
		vo.setNum(1);
		vo.setTitle("스프링 게시판 만들기");
		vo.setWriter("박매일");
		vo.setIndate(new Date());
		vo.setCount(0);
		List<Board> list=new ArrayList<>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		model.addAttribute("list", list);// 객체바인딩
		// list.jsp 넘겨주는것(ViewResolver)
		return "board/list"; // /WEB-INF/views/board/list.jsp
	}
}
