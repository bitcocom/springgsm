package kr.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Member;
import kr.board.mapper.BoardMapper;

@Controller
public class LoginController {

	@Autowired // dependency injection(DI) - 의존성 주입
	private BoardMapper mapper;
	
	@RequestMapping("/login")
	public String login(Member vo, HttpSession session) { // username, password
		Member mvo=mapper.login(vo);
		if(mvo!=null) {
			// 로그인 성공시 -> 성공여부를 세션 메모리에 연결(객체바인딩)
			session.setAttribute("mvo", mvo);
		}
		return "redirect:/list"; 
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 무효화
		return "redirect:/list";
	}
}
