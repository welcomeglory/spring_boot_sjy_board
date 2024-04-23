package edu.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.ex.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private CustomUserDetailsService customUserDetailsService;
	
	 /*	이미지(가영이)가 보이지 않는다.
	우선 정적파일들은 시큐리티에 적용되지 않도록 아래와 같이 설정을 한다.
	이제 더이상 리소스파일들은 스프링 시큐리티에서 관리를 하지 않는다.	*/	
	@Override
	public void configure(WebSecurity web) throws Exception {
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
		
		http.formLogin()
		        .loginPage("/login") //loginPage() 는 말그대로 로그인할 페이지 url 이고
		        .usernameParameter("id")
		        .passwordParameter("pw")
		        .defaultSuccessUrl("/")
		        .permitAll(); //모든 유저가 로그인 화면은 볼 수 있게 한다
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
		auth.userDetailsService(customUserDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder());
		
	}

}
