package edu.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ex.mapper.BoardMapper;
import edu.ex.mapper.CompanyMapper;
import edu.ex.page.Criteria;
import edu.ex.vo.BoardVO;
import edu.ex.vo.DeptEmpVO;
import edu.ex.vo.SalgradeEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public List<DeptEmpVO> getDeptEmpList(){
		log.info("getDeptEmpList()..");
		
		return companyMapper.getDeptEmpList();
	}

	@Override
	public List<SalgradeEmpVO> getSalgradeEmpList() {
		log.info("getSalgradeEmpList()..");

		return companyMapper.getSalgradeEmpList() ;
	}
	
	

}

