package edu.ex.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ex.service.UserService;
import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		log.info("login()..");
		return "/login/login";
	}	
	@GetMapping("/loginInfo")
	public String loginInfo(Authentication  authentication, Principal principal, Model model) {
		
		// 1. 로그인 정보를 체크하는 첫번째 방법 -  Principal principal 객체를 가져옴.
		if(principal != null) {
			System.out.println("타입정보 : "+ principal.getClass());
			System.out.println("ID정보 : "+ principal.getName());
		}
		
		// 2. 로그인 정보를 체크하는  두번째 방법 - Authentication authentication 객체를 가져옴.
		if(authentication != null) {
			System.out.println("타입정보 : "+ authentication.getClass());
			
			UserDetails user = (UserDetails) authentication.getPrincipal();
			System.out.println("패스워드 : "+user.getPassword());
			System.out.println("아이디 : "+user.getUsername());
			System.out.println("권한들 : "+user.getAuthorities());
			
			WebAuthenticationDetails web =
					(WebAuthenticationDetails) authentication.getDetails();
			
			System.out.println("섹션ID : "+web.getSessionId());
			System.out.println("접속IP : "+web.getRemoteAddress());			
		}		
		
		// 3. SpringContextHolder를 다이렉트로 가져오기.
		UserDetails user= (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user != null) {
			System.out.println("패스워드 : "+user.getPassword());
			System.out.println("아이디 : "+user.getUsername());
			System.out.println("권한들 : "+user.getAuthorities());
		}
		
		return "/login/login";
	}	
	
}


