package edu.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.ex.mapper.CompanyMapper;
import edu.ex.vo.EmpDetailsVO;
import edu.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpUserDetailsService implements UserDetailsService {
    
    @Autowired
    private CompanyMapper companyMapper;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	log.warn("Load User By UserVO member: " + username); 
        
        EmpVO empVO = companyMapper.getEmp(username);
        
        log.warn("queried by empVO mapper: " + empVO); 
        
        return empVO == null ? null : new EmpDetailsVO(empVO);
    }
}



