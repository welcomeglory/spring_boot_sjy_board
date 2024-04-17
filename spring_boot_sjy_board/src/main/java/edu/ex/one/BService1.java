package edu.ex.one;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ex.vo.BoardVO;

@Service
public class BService1 {
	@Autowired
//	private SqlSession SqlSession; //마이바티스
	private SqlSessionTemplate SqlSession;//마이바티스

	
	public List<BoardVO> selectBoardList() throws Exception{
		IBDao dao = SqlSession.getMapper(IBDao.class);
		return dao.listDao();
	}
	
	
}
