package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller
@Controller
public class BoardController { // new BoardController();

	// 요청-->처리메서드 : 핸들러매핑(HandlerMapping)
	// [게시판리스트보기 요청]이 오면 처리하는 [메서드]를 만들자
	@RequestMapping("/list.do")
	public String list() {
		// 데이터베이스에서 게시물을 가져오는 부분....
		// list.jsp 넘겨주는것(ViewResolver)
		return "board/list"; // /WEB-INF/views/board/list.jsp
	}
}
