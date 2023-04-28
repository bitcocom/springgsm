package kr.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Member;
import kr.board.mapper.BoardMapper;

@Controller
public class MemberController {

	@Autowired  // 1. dependency injection(DI : 의존성주입)
	private BoardMapper mapper;
	
	@RequestMapping("/login.do")
	public String login(Member vo ,HttpSession session) { // usename, password
		Member mvo=mapper.login(vo);
		if(mvo!=null) { // 회원인증성공
			session.setAttribute("mvo", mvo);
		}
		return "redirect:/list.do";
	}	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();//세션 무효화(로그아웃)
		return "redirect:/list.do";
	}
}



