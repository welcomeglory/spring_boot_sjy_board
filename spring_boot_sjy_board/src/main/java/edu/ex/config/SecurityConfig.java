package edu.ex.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

   @Override
   public void configure(WebSecurity web) throws Exception {
      //web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
      web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
   }

}