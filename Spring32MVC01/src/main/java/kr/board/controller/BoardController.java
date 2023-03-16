package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// POJO
@Controller
public class BoardController {
	// http://127.0.0.1:8081/s32/list
    //게시판리스트 보기(/list)--->list()
	@RequestMapping("/list")
	public String list() {
		return "board/list";
	}
}
