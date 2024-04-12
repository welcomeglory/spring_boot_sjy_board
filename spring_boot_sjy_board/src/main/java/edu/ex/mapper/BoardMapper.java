package edu.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
}

