package edu.ex.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
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

}