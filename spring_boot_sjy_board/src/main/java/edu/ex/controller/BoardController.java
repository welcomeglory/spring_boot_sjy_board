package edu.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ex.service.BoardService;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired 
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list()..");
		model.addAttribute("boards",boardService.getList());		
		return "/board/list";
	}
	@GetMapping("/content_view")
	public String content_view(@RequestParam("bid") int bid,Model model) {
		System.out.println("content_view()..");
		model.addAttribute("content_view",boardService.get(bid));		
		return "/board/content_view";
	}	
	@GetMapping("/delete")
	public String remove(@RequestParam("bid") int bid,Model model) {
		System.out.println("content_view()..");
		boardService.remove(bid);
		return "redirect:/board/list";
	}
	@GetMapping("/write_view")
	public String write_view() {
		System.out.println("write_view()..");
		return "/board/write_view";
	}
	@PostMapping("/write")
	public String write(BoardVO boardVO, Model model) {
		System.out.println("writeBoard()..");
		boardService.writeBoard(boardVO);
		return "redirect:/board/list";
	}
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, Model model) {
		System.out.println("writeBoard()..");
		boardService.modifyBoard(boardVO);
		return "redirect:/board/list";
	}
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO,Model model) {
		System.out.println("reply_view()..");
		model.addAttribute("reply_view",boardService.get(boardVO.getBid()));		

		return "/board/reply_view";
	}
	@PostMapping("/reply")
	public String reply(BoardVO boardVO,Model model) {
		System.out.println("reply()..");
		boardService.writeReply(boardVO);		
		return "redirect:/board/list";
	}
}


