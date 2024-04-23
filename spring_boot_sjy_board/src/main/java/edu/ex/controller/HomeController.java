package edu.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ex.service.EmpService;
import edu.ex.service.UserService;
import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private EmpService empService;	
	
	@GetMapping("/")
	public String home(Model model) {
		log.info("home()..");
		
		return "home";
	}
	
	
	@GetMapping("/user/userHome")
	public void userHome() {
		log.info("userHome()..");	
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		log.info("adminHome()..");
	}

	
	
	@GetMapping("/index")
	public String index(Model model) {
		log.info("index()..");
		
		model.addAttribute("deptEmps",empService.getDeptEmpList());	
		
		return "index";
	}
	
}


