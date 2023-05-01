package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Member;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(Member vo) {
		
		return null;
	}
}
