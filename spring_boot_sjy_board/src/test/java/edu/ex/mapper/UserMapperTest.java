package edu.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ex.vo.AuthVO;
import edu.ex.vo.DeptEmpVO;
import edu.ex.vo.EmpVO;
import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;

	@Test
	void testUserMapper() {
		assertNotNull(userMapper);
	}
	
	@Test
	void testgetUser() {
		UserVO user = userMapper.getUser("member");
		assertNotNull(user);
		System.out.println(user);
	}
}
