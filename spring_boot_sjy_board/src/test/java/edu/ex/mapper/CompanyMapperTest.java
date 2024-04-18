package edu.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ex.vo.DeptEmpVO;
import edu.ex.vo.EmpDeptVO;
import edu.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CompanyMapperTest {

	@Autowired
	private CompanyMapper companyMapper;

	@Test
	void test() {
		assertNotNull(companyMapper);
	}

	@Disabled
	@Test
	void testgetEmpDept() {
		for (EmpDeptVO empDeptVO : companyMapper.getEmpDept()) {
			log.info("연결" + empDeptVO);
		}
	}
	@Test
	void testgetDeptEmpList() {
		System.out.println(companyMapper);
		System.out.println(companyMapper.getDeptEmpList().size());
		for (DeptEmpVO vo : companyMapper.getDeptEmpList()) {
			System.out.println(vo);
			for (EmpVO emp : vo.getEmpList()) {
				System.out.println(emp);
			}
		}
	}	
}
