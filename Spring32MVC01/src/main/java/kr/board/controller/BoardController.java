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

// POJO
@Controller
public class BoardController {
	// http://127.0.0.1:8081/s32/list
    //게시판리스트 보기(/list)--->list()
	@Autowired
	private BoardMapper mapper;
	@RequestMapping("/list")
	public String list(Model model) {
		// 여기에 List<Board>구조로 게시물 3개를 저장하고
		// list.jsp로 넘기자
		List<Board> list=mapper.getLists();
		// 객체바인딩
	    model.addAttribute("list", list);		
		return "board/list"; // EL(표현식,출력식) : ${list}
	}
	@RequestMapping("/writefrm")
	public String writefrm() {
		return "board/writefrm"; // writefrm.jsp
	}
	@RequestMapping("/write")
	public String write(Board vo) { // title, content, writer
		mapper.write(vo); // 등록
		// 등록 후 다시 리스트페이지(/list)로 이동 : redirect
		return "redirect:/list";
	}
	@RequestMapping("/get") // ?num=10
	public String get(int num, Model model) {
		Board vo=mapper.get(num);
		model.addAttribute("vo", vo); // 객체바인딩
		// 조회수 증가
		mapper.count(num);
		return "board/get"; // get.jsp
	}
	@RequestMapping("/remove") // ?num=10
	public String remove(int num) {
        mapper.remove(num);		
		return "redirect:/list";
	}
	@RequestMapping("/updatefrm") // ?num=10
	public String updatefrm(int num, Model model) {
		Board vo=mapper.get(num);
		model.addAttribute("vo", vo);
		return "board/update"; // update.jsp
	}
	@RequestMapping("/update") // num, title, content
	public String update(Board vo) {
		mapper.update(vo);
		// 수정이 성공된 후에 다시 /list, /get
		return "redirect:/get?num="+vo.getNum();
	}
	@RequestMapping("/reply")
	public String reply(int num, Model model) {
		Board vo=mapper.get(num);
		model.addAttribute("vo", vo);
		return "board/reply"; // reply.jsp(답글UI)
	}
}



