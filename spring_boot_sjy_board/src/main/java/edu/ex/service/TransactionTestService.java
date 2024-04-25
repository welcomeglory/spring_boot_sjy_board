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
		 boardVO2.setBcontent("트랜잭션2");
		 boardVO2.setBname("트랜잭션2");
		 boardVO2.setBtitle("트랜잭션2");
		
		 mapper.insertBoard(boardVO2); 

	}
	
	public void TransactionTest2() {
		
		log.info("TransactionTest2()..");
		
		 BoardVO boardVO = new BoardVO();
		 boardVO.setBcontent("트랜잭션1");
		 boardVO.setBname("트랜잭션1");
		 boardVO.setBtitle("트랜잭션1");
		
		 mapper.insertBoard(boardVO);
		 
		 BoardVO boardVO2 = new BoardVO();
		 boardVO2.setBcontent("트랜잭션2");
		 boardVO2.setBname("트랜잭션2");
		 boardVO2.setBtitle("트랜잭션2");
		 
		 //일부러 트랜잭션을 위한 테스트로 null 값 셋팅
		 boardVO2 = null;		
		 mapper.insertBoard(boardVO2);	 

	}
	
	@Transactional //롤백
	public void TransactionTest3() {
		
		log.info("TransactionTest3()..");
		
		 BoardVO boardVO = new BoardVO();
		 boardVO.setBcontent("트랜잭션3");
		 boardVO.setBname("트랜잭션3");
		 boardVO.setBtitle("트랜잭션3");
		
		 mapper.insertBoard(boardVO);
		 
		 BoardVO boardVO2 = new BoardVO();
		 boardVO2.setBcontent("트랜잭션3");
		 boardVO2.setBname("트랜잭션3");
		 boardVO2.setBtitle("트랜잭션3");
		 
		 boardVO2 = null;		
		 mapper.insertBoard(boardVO2);	 

	}
	
	@Transactional //롤백
	public void TransactionTest4() {
		
		log.info("TransactionTest4()..");
		
		 BoardVO boardVO = new BoardVO();
		 boardVO.setBcontent("트랜잭션4");
		 boardVO.setBname("트랜잭션4");
		 boardVO.setBtitle("트랜잭션4");
		
		 mapper.insertBoard(boardVO);
		 
		 throw new RuntimeException("RuntimeException for rollback");

	}
}

