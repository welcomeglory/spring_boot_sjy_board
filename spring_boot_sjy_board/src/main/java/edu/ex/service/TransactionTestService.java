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
	private BoardMapper mapper;

	// Test1 : 트랜잭션 내에서 두 개의 삽입 작업을 시도합니다. 첫 번째 삽입이 성공하면 롤백X.
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

	// Test2 : 트랜잭션 내에서 두 개의 삽입 작업을 시도하지만, 두 번째 삽입 작업 직전에 일부러 예외를 발생시켜 롤백될 수 있도록 함.
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

		// 일부러 트랜잭션을 위한 테스트로 null 값 셋팅
		boardVO2 = null;
		mapper.insertBoard(boardVO2);

	}

	// Test3 : 트랜잭션 내에서 두 개의 삽입 작업을 시도하지만,
	// 두 번째 삽입 작업 직전에 일부러 예외를 발생시켜 롤백될 수 있도록 합니다. 이 메서드에서는 @Transactional 어노테이션이
	// 메서드에 적용함.
	@Transactional // 롤백 언제? 함수에서 에러가 나면
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

	// RuntimeException을 발생시켜 트랜잭션을 롤백하는 경우를 시뮬레이션합니다.
	// 트랜잭션 내에서 데이터를 삽입한 후, 특정 조건에서 의도적으로 런타임 예외를 발생시킵니다. 이러한 경우 트랜잭션은 롤백되며, 이전에 삽입한
	// 데이터도 롤백됩니다.
	@Transactional // 롤백
	public void TransactionTest4() {

		log.info("TransactionTest4()..");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션4");
		boardVO.setBname("트랜잭션4");
		boardVO.setBtitle("트랜잭션4");

		mapper.insertBoard(boardVO);

		throw new RuntimeException("RuntimeException for rollback");

	}
	// SQLException을 발생시켜도 롤백되지 않는 경우를 시뮬레이션합니다. 트랜잭션 내에서 데이터를 삽입한 후, 
	// 특정 조건에서 의도적으로 SQL 예외를 발생시킵니다. 이 예외는 rollbackFor 옵션에 명시되지 않았으므로 롤백되지 않고, 
	// 데이터베이스에는 삽입된 데이터가 남게 됩니다.
	// CheckedException 테스트(롤백안함)
	@Transactional // 롤백
	public void TransactionTest5() throws SQLException {

		log.info("TransactionTest5()..");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");

		mapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");

	}
		
	// @Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	// Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. @Transactional(rollbackFor =
	// Exception.class)
	// 여러개의 예외를 지정할 수도 있습니다. @Transactional(rollbackFro = {RuntimeException.class,
	// Exception.class})
	// @Transactional 어노테이션의 rollbackFor 옵션을 사용하여 SQLException이 발생했을 때 트랜잭션을 롤백하는 경우를 시뮬레이션합니다. 
	// 따라서 SQLException이 발생하면 해당 트랜잭션은 롤백되며, 이전에 삽입한 데이터도 롤백됩니다.
	@Transactional(rollbackFor = Exception.class) // 롤백
	public void TransactionTest6() throws SQLException {

		log.info("TransactionTest6()..");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");

		mapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");
		
	}
	
	// @Transactional 어노테이션의 rollbackFor 옵션을 사용하여 SQLException이 발생했을 때 트랜잭션을 롤백하는 경우를 시뮬레이션합니다. 
	// 따라서 SQLException이 발생하면 해당 트랜잭션은 롤백되며, 이전에 삽입한 데이터도 롤백됩니다. 이전과는 달리 SQLException에 대한 롤백이 명시적으로 지정되었습니다.
	// 다형성 적용시켜서
	@Transactional(rollbackFor = SQLException.class) // 롤백
	public void TransactionTest7() throws SQLException {

		log.info("TransactionTest7()..");

		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션7");
		boardVO.setBname("트랜잭션7");
		boardVO.setBtitle("트랜잭션7");

		mapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");

	}
}
