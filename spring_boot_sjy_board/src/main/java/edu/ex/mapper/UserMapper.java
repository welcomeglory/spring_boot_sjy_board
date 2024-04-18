package edu.ex.mapper;

import org.apache.ibatis.annotations.Mapper;
import edu.ex.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public UserVO getUser(String username);
	
	public int insertUser(UserVO userVO);
	public void insertAuthoruties(UserVO userVO);
	
}

