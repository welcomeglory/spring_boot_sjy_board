package edu.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ex.service.BoardService;
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
}


