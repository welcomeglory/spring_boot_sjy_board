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
import edu.ex.service.CompanyService;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp/*")
public class EmpController {
	
	@Autowired 
	CompanyService companyService;
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("DeptEmpList()..");
		model.addAttribute("DeptEmps",companyService.getDeptEmpList());		
		return "/emp/list";
	}
	
	@GetMapping("/salgrade")
	public String list3(Model model) {
		System.out.println("DeptEmpList()..");
		model.addAttribute("DeptEmps",companyService.getDeptEmpList());		
		return "/emp/list3";
	}	
}


