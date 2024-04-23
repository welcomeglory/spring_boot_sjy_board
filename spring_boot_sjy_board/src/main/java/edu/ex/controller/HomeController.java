package edu.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ex.service.UserService;
import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@Autowired 
	private UserService userService;
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("home()..");
		return "home";
	}	
	
	
	 @GetMapping("/user/userHome") 
	 public void userHome() {
		 System.out.println("userHome().."); 
	 }
	 
	
//	@GetMapping("/user/userHome")
//	public String userHome() {
//		System.out.println("userHome()..");
//		return "/user/userHome";
//	}	
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		System.out.println("adminHome()..");
	}	
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login()..");
		return "login";
	}
	@PostMapping("/write")
	public String write(UserVO userVO,Model model) {
		System.out.println("write()..");
//		userService.insertUser(userVO);	
//		userService.insertAuthoruties(userVO);	
		userService.addUser(userVO);
		return "redirect:/index";
	}	
}


