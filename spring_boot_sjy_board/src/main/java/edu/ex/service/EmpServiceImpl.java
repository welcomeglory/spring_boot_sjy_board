package edu.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ex.mapper.CompanyMapper;
import edu.ex.vo.DeptEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public List<DeptEmpVO> getDeptEmpList(){
		log.info("getDeptEmpList()..");
		
		return companyMapper.getDeptEmpList();
	}
}

