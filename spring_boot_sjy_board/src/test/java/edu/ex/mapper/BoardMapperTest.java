package edu.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Disabled
	@Test
	void testBoardMapper() {
		assertNotNull(boardMapper);
	}
	@Disabled
	@Test
	void testSelectList() {
		for(BoardVO boardVO : boardMapper.getList() ) {
			log.info("연결"+boardVO);
		}
	}
	@Disabled
	@Test
	void testRead() {
		System.out.println(boardMapper.read(26));
	}
	
	@Test
	void testSelectList2() {
		for(BoardVO boardVO : boardMapper.getList2() ) {
			log.info("연결"+boardVO);
		}
	}

}
