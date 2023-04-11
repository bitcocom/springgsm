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

// Controller
@Controller
public class BoardController { // new BoardController();

	@Autowired
	private BoardMapper mapper;
	// 요청-->처리메서드 : 핸들러매핑(HandlerMapping)
	// [게시판리스트보기 요청]이 오면 처리하는 [메서드]를 만들자
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<Board> list=mapper.getLists();
		model.addAttribute("list", list);// 객체바인딩
		// list.jsp 넘겨주는것(ViewResolver)
		return "board/list"; // /WEB-INF/views/board/list.jsp
	}
	
	@RequestMapping("/register.do")
	public String register() {
		return "board/register"; // register.jsp : forward
	}
	
	@RequestMapping("/insert.do")
	public String insert(Board vo) {// 파라메터수집(VO)
		mapper.insert(vo); // 등록성공
		// 등록후 다시 리스트페이지로 전환(redirect)
		return "redirect:/list.do";
	}
}





