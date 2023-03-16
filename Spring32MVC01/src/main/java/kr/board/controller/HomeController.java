package kr.board.controller;

import org.springframework.stereotype.Controller;
// Controller 만들기(POJO)
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    // HandlerMapping
	@RequestMapping("/")
	public String home() {
		return "index"; // index=>/WEB-INF/views/index.jsp:ViewResolver
	}
}
