package kr.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.board.entity.Board;
import kr.board.entity.Criteria;
import kr.board.entity.PageMaker;
import kr.board.mapper.BoardMapper;

// POJO
@Controller
public class BoardController {
	// http://127.0.0.1:8081/s32/list
    //게시판리스트 보기(/list)--->list()
	@Autowired
	private BoardMapper mapper;
	@RequestMapping("/list")
	public String list(Criteria cri,Model model) {
		// 여기에 List<Board>구조로 게시물 3개를 저장하고
		// list.jsp로 넘기자
		List<Board> list=mapper.getLists(cri);
		// 객체바인딩
	    model.addAttribute("list", list);	
	    // PageMaker만들기
	    PageMaker pm=new PageMaker();
	    pm.setCri(cri);
	    pm.setTotalCount(mapper.totalCount(cri));
	    model.addAttribute("pm", pm);	    
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
	public String get(int num, Model model, @ModelAttribute("cri") Criteria cri) {
		Board vo=mapper.get(num);
		model.addAttribute("vo", vo); // 객체바인딩
		// 조회수 증가
		mapper.count(num);
		return "board/get"; // get.jsp
	}
	@RequestMapping("/remove") // ?num=10
	public String remove(int num, Criteria cri, RedirectAttributes rttr) {
        mapper.remove(num);		
        rttr.addAttribute("page", cri.getPage()); // ?page=5
		return "redirect:/list";
	}
	@RequestMapping("/updatefrm") // ?num=10
	public String updatefrm(int num, Model model, @ModelAttribute("cri") Criteria cri) {
		Board vo=mapper.get(num);
		model.addAttribute("vo", vo);
		return "board/update"; // update.jsp
	}
	@RequestMapping("/update") // num, title, content
	public String update(Board vo, Criteria cri, RedirectAttributes rttr) {
		mapper.update(vo);
		// 수정이 성공된 후에 다시 /list, /get
		rttr.addAttribute("num", vo.getNum());
		rttr.addAttribute("page", cri.getPage());
		
		return "redirect:/get";
	}
	@GetMapping("/reply")
	public String reply(int num, Model model, @ModelAttribute("cri") Criteria cri) {
		Board vo=mapper.get(num);
		model.addAttribute("vo", vo);
		return "board/reply"; // reply.jsp(답글UI)
	}
	@PostMapping("/reply")
	public String reply(Board vo, Criteria cri, RedirectAttributes rttr) { //num(부모글번호),username, title, content, writer
		// 답글의 bgroup, bseq, blevel을 구하는 작업
		// 1. 부모글의 정보를 가져오기
		Board parent=mapper.get(vo.getNum()); // bgroup, bseq, blevel
		// 2. 답글의 bgroup만들기
		vo.setBgroup(parent.getBgroup());
		// 3. 답글의 bseq만들기
		vo.setBseq(parent.getBseq()+1);
		// 4. 답글의 blevel만들기
		vo.setBlevel(parent.getBlevel()+1);
		// 5. 부모의 bgroup과 같고 부모의 bseq보다 큰 답글의 순서를 뒤로 한칸씩 밀춘다.
		mapper.replyUpdate(parent);
		// 6. 답글을 저장
		mapper.replyInsert(vo);		
		
		rttr.addAttribute("page", cri.getPage());
		
		return "redirect:/list";
	}
}



