package kr.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class BoardController {
   
	// /list.do 요청이 오면 처리하는 메서드 정의
	@RequestMapping("/list.do")
	public String list() {
		
		return "";
	}
	
	@RequestMapping("/register.do")
    public String register() {
		
		return "";
	}
	
}
