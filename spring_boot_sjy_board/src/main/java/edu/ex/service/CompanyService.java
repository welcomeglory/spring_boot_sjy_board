package edu.ex.service;

import java.util.List;

import edu.ex.vo.DeptEmpVO;
import edu.ex.vo.SalgradeEmpVO;

public interface CompanyService {

	List<DeptEmpVO> getDeptEmpList();
	List<SalgradeEmpVO> getSalgradeEmpList();
	
}
