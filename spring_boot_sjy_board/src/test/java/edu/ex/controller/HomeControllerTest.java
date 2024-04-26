package edu.ex.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;//HTTP 호출을 위한 MockMvc 사용

	@BeforeEach//Junit4@Before
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}
	
	@Test
	void testHome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}

}
