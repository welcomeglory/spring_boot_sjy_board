package edu.ex.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import edu.ex.vo.EmpDeptVO;

@Mapper
public interface CompanyMapper {
	List<EmpDeptVO> getEmpDept();	
}
