package edu.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ex.page.Criteria;
import edu.ex.page.PageVO;
import edu.ex.service.BoardService;
import edu.ex.service.TransactionTestService;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tx/*")
public class TransactionTestController {
	
	@Autowired
	private TransactionTestService TransactionTestService;
	
	@GetMapping("/{num}")
	public String Transaction(@PathVariable("num")int num) {
		log.info("Transaction().."+num);
		
		if(num == 1) {
		TransactionTestService.TransactionTest1();
		}
		
		if(num == 2) {
			TransactionTestService.TransactionTest2();
		}
		
		if(num == 3) {
			TransactionTestService.TransactionTest3();
		}
		
		if(num == 4) {
			TransactionTestService.TransactionTest4();
		}
		
		return "redirect:/board/list2";
	}
	
}


