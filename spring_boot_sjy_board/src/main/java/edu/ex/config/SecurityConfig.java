package edu.ex.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//정적 리소스를 스프링 시큐리티에 적용되지 않도록 아래와 같이 설정한다.
	//이제 더이상 리소트파일들은 스프링 시큐리티에서 관리하지 않는다.
   @Override
   public void configure(WebSecurity web) throws Exception {
	   //web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
      web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
   }
   
   //인증과 권한 설정
   @Override
   public void configure(HttpSecurity http) throws Exception {
	   //우선 CSRF설정을 해제한다.
	   //초기 개발시만 해주는게 좋다.
	   http.csrf().disable();
	   
	   //권한설정
	   http.authorizeRequests()
	   .antMatchers("/user/**").hasAnyRole("USER")
	   .antMatchers("/admin/**").hasAnyRole("ADMIN")
	   .antMatchers("/**").permitAll();
	   	   
	   http.formLogin();//스프링 시큐리티에 있는 기본 로그인 폼을 사용하겠다.
   }
   
   //테스트용 유저 만들기(인메모리 방식)
   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
	   //{noop} 암호화 안된 password를 의미함.
	   auth.inMemoryAuthentication()
	   .withUser("member").password("{noop}member").roles("USER")
	   .and()
	   .withUser("admin").password("{noop}admin").roles("ADMIN");	 
   }

}