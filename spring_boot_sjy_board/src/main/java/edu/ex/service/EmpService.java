package edu.ex.service;

import java.util.List;

import edu.ex.vo.DeptEmpVO;

public interface EmpService {

	List<DeptEmpVO> getDeptEmpList(); //일대다
	
}
