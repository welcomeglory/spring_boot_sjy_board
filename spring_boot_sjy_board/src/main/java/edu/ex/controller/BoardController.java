package edu.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ex.page.Criteria;
import edu.ex.page.PageVO;
import edu.ex.service.BoardService;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired 
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list()..");
		//getList()
		model.addAttribute("boards",boardService.getList());		
		return "/board/list";
	}
	//<a href="list2?pageNum=2&amp;amount=10">2</a>
	//2페이지에 있는 10개
	//list2받게 되면 Criteria커멘드 객체를 받게 된다.
	@GetMapping("/list2")
	public String list2(Criteria criteria, Model model) {
		log.info("list2()..");
		
		//getListWithPaging() 2,10 // 2페이지에 10개 가져옴
		model.addAttribute("boards",boardService.getListWithPaging(criteria));		
		
		int total = boardService.getTotal();
		//페이지 만들기 위한 정보를 가져오는데 PageVO변수를 통해 view로 전달?
		model.addAttribute("pageMaker", new PageVO(criteria,total));
		
		return "/board/list2";
	}	
	
	@GetMapping("/content_view")
	public String content_view(@RequestParam("bid") int bid,Model model) {
		log.info("content_view()..");
		model.addAttribute("content_view",boardService.get(bid));		
		return "/board/content_view";
	}	
	@GetMapping("/delete")
	public String remove(@RequestParam("bid") int bid,Model model) {
		log.info("content_view()..");
		boardService.remove(bid);
		return "redirect:/board/list2";
	}
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view()..");
		return "/board/write_view";
	}
	@PostMapping("/write")
	public String write(BoardVO boardVO, Model model) {
		log.info("writeBoard()..");
		boardService.writeBoard(boardVO);
		return "redirect:/board/list2";
	}
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, Model model) {
		log.info("writeBoard()..");
		boardService.modifyBoard(boardVO);
		return "redirect:/board/list2";
	}
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO,Model model) {
		log.info("reply_view()..");
		model.addAttribute("reply_view",boardService.get(boardVO.getBid()));		

		return "/board/reply_view";
	}
	@PostMapping("/reply")
	public String reply(BoardVO boardVO,Model model) {
		log.info("reply()..");
		boardService.writeReply(boardVO);		
		return "redirect:/board/list2";
	}
	
}


