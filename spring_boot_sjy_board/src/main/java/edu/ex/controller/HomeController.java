package edu.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ex.service.CompanyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@Autowired 
	CompanyService companyService;
	
	@GetMapping("/index")
	public String index(Model model) {
		System.out.println("index()..");
		model.addAttribute("DeptEmps",companyService.getDeptEmpList());	

		return "index";
	}	
}


