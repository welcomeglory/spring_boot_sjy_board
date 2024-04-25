package edu.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ex.mapper.BoardMapper;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionTestService {
	
	@Autowired
	private  BoardMapper mapper;
	
	@Transactional
	public void TransactionTest1() {
		
		log.info("TransactionTest1()..");
		
		 BoardVO boardVO = new BoardVO();
		 boardVO.setBcontent("트랜잭션1");
		 boardVO.setBname("트랜잭션1");
		 boardVO.setBtitle("트랜잭션1");
		
		 mapper.insertBoard(boardVO);
		 
		 BoardVO boardVO2 = new BoardVO();
		 boardVO.setBcontent("트랜잭션2");
		 boardVO.setBname("트랜잭션2");
		 boardVO.setBtitle("트랜잭션2");
		
		 mapper.insertBoard(boardVO2);

	}
}

