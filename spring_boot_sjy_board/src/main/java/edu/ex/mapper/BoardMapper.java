package edu.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ex.page.Criteria;
import edu.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
	void uphitBoard(int bid);
	BoardVO read(int bid);
	int delete(int bid);
	int insertBoard(BoardVO boardVO);
	int updateBoard(BoardVO boardVO);
	//댓글관련
	void updateShape(BoardVO boardVO); //답글위치(들어갈자리에 스텝을 한칸씩 밀어내는 함수)
	void insertReply(BoardVO boardVO);//답글등록
	//페이징관련
	List<BoardVO> getListWithPaging(Criteria cri);
	int getTotalCount();
	
}

