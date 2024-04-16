package edu.ex.service;

import java.util.List;

import edu.ex.page.Criteria;
import edu.ex.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getList();
	BoardVO get(int bid);
	int remove(int bid);
	void writeBoard(BoardVO boardVO);
	int modifyBoard(BoardVO boardVO);
	
	//댓글
	void writeReply(BoardVO boardVO);
	
	//페이징 처리 함수
	int getTotal();
	List<BoardVO> getListWithPaging(Criteria cri);

}

