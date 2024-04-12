package edu.ex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//mapper상에서 마이바티스로 하여금 인터페이스 위치를 알려줌
@MapperScan(value= {"edu.ex.mapper"})
@SpringBootApplication
public class SpringBootSjyBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSjyBoardApplication.class, args);
	}

}
