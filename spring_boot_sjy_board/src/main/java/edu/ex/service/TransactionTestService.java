package edu.ex.service;

import java.sql.SQLException;

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
	
	@Transactional //롤백 언제? 함수에서 에러가 나면 
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
	//CheckedException 테스트(롤백안함)
	@Transactional //롤백
	public void TransactionTest5() throws SQLException{
		
		log.info("TransactionTest5()..");
		
		 BoardVO boardVO = new BoardVO();
		 boardVO.setBcontent("트랜잭션5");
		 boardVO.setBname("트랜잭션5");
		 boardVO.setBtitle("트랜잭션5");
		
		 mapper.insertBoard(boardVO);
		 
		 throw new SQLException("SQLException for rollback");

	}
		//@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	   // Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. @Transactional(rollbackFor = Exception.class) 
	   // 여러개의 예외를 지정할 수도 있습니다. @Transactional(rollbackFro = {RuntimeException.class, Exception.class})
		@Transactional (rollbackFor = Exception.class)//롤백
		public void TransactionTest6() throws SQLException{
			
			log.info("TransactionTest6()..");
			
			 BoardVO boardVO = new BoardVO();
			 boardVO.setBcontent("트랜잭션5");
			 boardVO.setBname("트랜잭션5");
			 boardVO.setBtitle("트랜잭션5");
			
			 mapper.insertBoard(boardVO);
			 
			 throw new SQLException("SQLException for rollback");

		}
		// 다형성 적용시켜서 
		@Transactional (rollbackFor = SQLException.class)//롤백
		public void TransactionTest7() throws SQLException{
			
			log.info("TransactionTest7()..");
			
			 BoardVO boardVO = new BoardVO();
			 boardVO.setBcontent("트랜잭션7");
			 boardVO.setBname("트랜잭션7");
			 boardVO.setBtitle("트랜잭션7");
			
			 mapper.insertBoard(boardVO);
			 
			 throw new SQLException("SQLException for rollback");

		}
}

