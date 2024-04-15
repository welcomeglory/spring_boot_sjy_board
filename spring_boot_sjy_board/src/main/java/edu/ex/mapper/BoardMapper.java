package edu.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
	BoardVO read(int bid);
	int delete(int bid);
	int insertBoard(BoardVO boardVO);
	int updateBoard(BoardVO boardVO);
	//댓글관련
	void updateShape(BoardVO boardVO); //답글위치
	void insertReply(BoardVO boardVO);//답글등록
}

