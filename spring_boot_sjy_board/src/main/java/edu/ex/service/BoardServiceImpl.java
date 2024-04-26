package edu.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ex.mapper.BoardMapper;
import edu.ex.page.Criteria;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList(){
		log.info("getList..");
		
		return boardMapper.getList();
	}
	
	@Override
	public BoardVO get(int bid) {
		log.info("read..");
		boardMapper.uphitBoard(bid);		
		return boardMapper.read(bid);
	}
	
	@Override
	public int remove(int bid) {
		log.info("delete..");
		return boardMapper.delete(bid);
	}
	
	@Override
	public void writeBoard(BoardVO boardVO) {
		log.info("insertBoard..");
		boardMapper.insertBoard(boardVO);		
	}
	
	@Override
	public int modifyBoard(BoardVO boardVO) {
		log.info("modifyBoard..");
		return boardMapper.updateBoard(boardVO);
	}
	
	@Transactional(rollbackFor = Exception.class)//에러 객체를 폴리멀피즘 적용해서 사용해야 함.	
	@Override
	public void writeReply(BoardVO boardVO) {
		log.info("writeReply()..");
		
		boardMapper.updateShape(boardVO);//답글의 위치를 먼저 잡아준 후
		boardMapper.insertReply(boardVO);//답글을 등록한다.
	}
	
	@Override
	public int getTotal() {
		log.info("getTotal()..");
		return boardMapper.getTotalCount();
	}
	
	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		log.info("getListWithPaging()..");
		return boardMapper.getListWithPaging(cri);
	}

}

