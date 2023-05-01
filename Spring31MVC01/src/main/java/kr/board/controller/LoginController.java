package kr.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Member;
import kr.board.mapper.BoardMapper;

@Controller
public class LoginController {

	@Autowired
	private BoardMapper mapper;
	
	@RequestMapping("/login.do")
	public String login(Member vo, HttpSession session) {
		Member mvo=mapper.login(vo);
		// 회원인증의 성공 여부를 메모리에 연결시키는 방법(객체바인딩:HttpSession)
		if(mvo!=null) {
			session.setAttribute("mvo", mvo);
		}
		return "redirect:/list.do";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); // 무효화
		return "redirect:/list.do";
	}
}





