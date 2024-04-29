package edu.ex.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

import edu.ex.page.Criteria;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class SecurityControllerTest {

	@Autowired
	private MockMvc mockMvc;//웹브라우져 가져오기
	
	@Disabled
	@Test
	@WithMockUser(username="admin", password="admin", authorities="ROLE_ADMIN")
	void testAdminPage() throws Exception {
		
		//관리자 홈
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminHome"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());	
		
	}
	
	@Test
	@WithMockUser(username="user", password="user", authorities="ROLE_USER")
	void testUserPage() throws Exception {
		
		//사용자 홈
		mockMvc.perform(MockMvcRequestBuilders.get("/user/userHome"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());	
		
	}
	
}
