package edu.ex.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

import edu.ex.page.Criteria;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

	@Autowired
	private MockMvc mockMvc;//웹브라우져 가져오기
	
	@Disabled
	@Test
	void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());		
	}
	
	@Test
	void testBoard() throws Exception {
		
		int pageNum = 2;
		int amount = 10;		
		
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list2")
				.param("pageNum", String.valueOf(pageNum)).param("amount", String.valueOf(amount)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}	
	
	@Test
	void testBoardJson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/boards/list"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}

}
