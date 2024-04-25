package edu.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.ex.security.CustomNoOpPasswordEncoder;
import edu.ex.security.CustomUserDetailsService;
import edu.ex.security.EmpUserDetailsService;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private CustomUserDetailsService customUserDetailsService;	
	 
	 @Autowired
	 private EmpUserDetailsService empUserDetailsService;	
	 
	 /*	이미지(가영이)가 보이지 않는다.
	우선 정적파일들은 시큐리티에 적용되지 않도록 아래와 같이 설정을 한다.
	이제 더이상 리소스파일들은 스프링 시큐리티에서 관리를 하지 않는다.	*/	
	 
	@Override
	public void configure(WebSecurity web) throws Exception {
		//Spring Security에서 정적 리소스에 대한 요청을 무시하도록 설정
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//우선 CSRF설정을 해제한다.
		//초기 개발시만 해주는게 좋다.
		http.csrf().disable();
		
		/*권한 설정*/
		http.authorizeRequests()
		.antMatchers("/user/**").hasAnyRole("USER") 
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/**").permitAll();
		
		http.formLogin() // 폼 기반 로그인 설정 시작
	    .loginPage("/login") // 로그인 페이지 경로 설정
	    .usernameParameter("id") // 사용자 이름(아이디) 파라미터 설정
	    .passwordParameter("pw") // 비밀번호 파라미터 설정
	    .defaultSuccessUrl("/") // 로그인 성공 시 이동할 기본 URL 설정
	    .permitAll(); // 로그인 페이지 및 관련 요청에 대한 모든 사용자 접근 허용
	}
	// PasswordEncoder 부모, BCryptPasswordEncoder 자식
	//암호화모듈
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return new CustomNoOpPasswordEncoder();
	}	
	
	//테스트용 유저 만들기(인메모리 방식)
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure()..");
		/*
		 * auth .inMemoryAuthentication()
		 * .withUser("member").password("{noop}member").roles("USER") .and()
		 * .withUser("admin").password("{noop}admin").roles("ADMIN");
		 */
		// BCryptPasswordEncoder를 사용하여 비밀번호를 안전하게 해싱합니다.
	    // 사용자 지정 사용자 세부 정보 서비스(customUserDetailsService)를 지정하고,
	    // 해당 서비스를 통해 사용자의 인증 정보를 가져온 후 비밀번호를 비교합니다.
//		auth.userDetailsService(customUserDetailsService)
//				.passwordEncoder(passwordEncoder());
		auth.userDetailsService(empUserDetailsService)
			.passwordEncoder(passwordEncoder());
	}
}
