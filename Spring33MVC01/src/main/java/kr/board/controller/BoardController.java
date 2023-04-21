package kr.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@RequestMapping("/write")
	public String write(Board vo) { // title, content, writer -> 파라메터수집(VO)
		mapper.write(vo); //등록성공
		//등록이 성공후에는 다시 리스트페이지로 이동
		return "redirect:/list.do"; // /WEB-INF/views/board//list.do.jsp
	}
	@RequestMapping("/get.do") // ?num=10
	public String get(int num, Model model) {
		Board vo=mapper.get(num);
		// 객체바인딩
		model.addAttribute("vo", vo);
		return "board/get"; // get.jsp : forward
	}
	@RequestMapping("/remove.do") // ?num=10
	public String remove(int num) {
	    mapper.remove(num);
	    // 삭제가 성공후에는 다시 리스트페이지로(/list.do) 전환시키기:redirect
		return "redirect:/list.do";
	}
	@GetMapping("/update.do") // ?num=10
	public String update(int num, Model model) {
		Board vo=mapper.get(num);
		model.addAttribute("vo", vo);
		return "board/update"; // update.jsp(수정화면)
	}
	@PostMapping("/update.do")
	public String update(Board vo) { // num, title, content
		mapper.update(vo);
		// 수정 성공후 다시 리스트페이지로 이동(/list.do)
		// 수정 성공후 다시 상세보기페이지로 이동(/get.do?num=10)
		return "redirect:/get.do?num="+vo.getNum();
	}
}









