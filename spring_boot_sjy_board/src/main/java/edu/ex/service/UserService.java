package edu.ex.service;

import edu.ex.vo.UserVO;

public interface UserService {
	
//	public UserVO getUser(String username);
	
	public int insertUser(UserVO userVO);
	public void insertAuthoruties(UserVO userVO);
}
