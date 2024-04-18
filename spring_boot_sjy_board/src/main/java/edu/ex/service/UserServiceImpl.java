package edu.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ex.mapper.CompanyMapper;
import edu.ex.mapper.UserMapper;
import edu.ex.vo.DeptEmpVO;
import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int insertUser(UserVO userVO) {
		log.info("insertUser..");
		return userMapper.insertUser(userVO);
	}

	@Override
	public void insertAuthoruties(UserVO userVO) {
		userMapper.insertAuthoruties(userVO);
	}
}

