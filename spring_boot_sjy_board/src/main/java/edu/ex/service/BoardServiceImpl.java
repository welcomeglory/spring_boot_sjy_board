package edu.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ex.mapper.BoardMapper;
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
	@Override
	public void writeReply(BoardVO boardVO) {
		log.info("writeReply..");
		boardMapper.updateShape(boardVO);//답글의 위치를 먼저 잡아준 후
		boardMapper.insertReply(boardVO);//답글을 등록한다.
	}

}

