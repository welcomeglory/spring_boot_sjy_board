package edu.ex.page;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ex.mapper.BoardMapper;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PageVOTest {
	
	@Autowired
	private BoardMapper boardMapper;

	@Test
	void testPageVO() {
		assertNotNull(boardMapper);
	}
	
	@Test
	void tesPaging() {
		Criteria cri  =  new Criteria();
		assertNotNull(cri);
		
		List<BoardVO> boards = boardMapper.getListWithPaging(cri);
		
		cri.setPageNum(3);
		cri.setAmount(10);
		
		
		boards = boardMapper.getListWithPaging(cri);
		
		for(BoardVO board: boards) {
			System.out.println(board);
		}
	}
	
	

}
