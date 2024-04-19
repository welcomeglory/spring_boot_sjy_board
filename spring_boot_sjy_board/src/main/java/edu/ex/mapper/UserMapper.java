package edu.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import edu.ex.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public UserVO getUser(String username);
	
//	public int insertUser(UserVO userVO);
//	
//	public void insertAuthoruties(UserVO userVO);
		
	@Insert("insert into users(username,password) VALUES (#{username},#{password})")
	public int insertUser(UserVO userVO);
	
	@Insert("insert into authorities(username,authority) values(#{username},'ROLE_USER')")
	public void insertAuthoruties(UserVO userVO);
	
}

