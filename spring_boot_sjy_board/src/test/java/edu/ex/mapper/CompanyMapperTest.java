package edu.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ex.vo.BoardVO;
import edu.ex.vo.DeptEmpVO;
import edu.ex.vo.EmpDeptVO;
import edu.ex.vo.SalgradeEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CompanyMapperTest {

	@Autowired
	private CompanyMapper  companyMapper;	
	
	@Test
	void test() {
		assertNotNull(companyMapper);
	}
	@Disabled
	@Test
	void testgetEmpDept() {
		for(EmpDeptVO empDeptVO : companyMapper.getEmpDept() ) {
			log.info("연결"+empDeptVO);
		}
	}
	@Disabled
	@Test
	void testgetDeptEmpList() {
		for(DeptEmpVO vo : companyMapper.getDeptEmpList() ) {
			System.out.println("연결"+vo);
		}
	}
	@Test
	void testgetSalgradeEmpList() {
		for(SalgradeEmpVO vo : companyMapper.getSalgradeEmpList() ) {
			System.out.println("연결"+vo);
		}
	}
	

}
