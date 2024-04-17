package edu.ex.two;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ex.page.Criteria;
import edu.ex.vo.BoardVO;

@Service
public class BService2 {
	@Autowired
	private SqlSessionTemplate SqlSession;//마이바티스
	
	public List<BoardVO> selectBoardList() throws Exception{
		//모든 CRUD에 대해 함수를 제공해줌.
		return SqlSession.selectList("board.selectBoardList");		
	}					
	public List<BoardVO> selectBoardPagingList(Criteria cri) throws Exception{
		//모든 CRUD에 대해 함수를 제공해줌.
		return SqlSession.selectList("board.selectBoardPagingList",cri);		
	}
	//하나 뽑아낼땐 selectOne()사용
	public int getTotal() throws Exception{
		return  SqlSession.selectOne("board.getTotal");
	}
}
