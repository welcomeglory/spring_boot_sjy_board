package edu.ex.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import edu.ex.vo.DeptEmpVO;
import edu.ex.vo.EmpDeptVO;
import edu.ex.vo.SalgradeEmpVO;

@Mapper
public interface CompanyMapper {
	List<EmpDeptVO> getEmpDept();	
	List<DeptEmpVO> getDeptEmpList();
	List<SalgradeEmpVO> getSalgradeEmpList();
}
