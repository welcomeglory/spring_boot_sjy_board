package edu.ex.vo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class AuthVOTest {

	@Test
	void testAuthVO() {
		AuthVO authVO = new AuthVO();
		assertNotNull(authVO);
	}
	
	@Test
	void testGetUsername() {
		AuthVO authVO = new AuthVO();
		assertNotNull(authVO);
		
		authVO.setUsername("홍길동");
		assertEquals("홍길동", authVO.getUsername());
				
	}

}
