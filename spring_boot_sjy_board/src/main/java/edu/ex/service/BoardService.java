package edu.ex.service;

import java.util.List;

import edu.ex.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getList();
	BoardVO get(int bid);
	int remove(int bid);
	void writeBoard(BoardVO boardVO);
}

