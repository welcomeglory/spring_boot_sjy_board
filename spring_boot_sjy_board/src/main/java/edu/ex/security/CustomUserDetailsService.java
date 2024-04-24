package edu.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.ex.mapper.CompanyMapper;
import edu.ex.mapper.UserMapper;
import edu.ex.vo.EmpVO;
import edu.ex.vo.UserDetailsVO;
import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
    //UserDetailsVO에서 받은 form에 작성된 정보를 faxservice에 전달
	//ex)faxservice
    @Autowired
    private UserMapper userMapper; // UserMapper 인터페이스를 자동으로 주입받습니다. 이를 통해 데이터베이스에 대한 쿼리를 수행하여 사용자 정보를 가져올 수 있습니다.
    
    @Autowired
    private CompanyMapper companyMapper;
    

    // 사용자 이름을 받아 해당 사용자의 정보를 데이터베이스에서 가져오는 메서드입니다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// 사용자 이름을 로그에 기록.
    	log.warn("Load User By UserVO member: " + username); 
        
        // 데이터베이스에서 사용자 정보를 가져오는 부분입니다.
        UserVO user = userMapper.getUser(username); // userMapper를 사용하여 입력된 사용자 이름에 해당하는 사용자 정보를 데이터베이스에서 가져옵니다.
        
        EmpVO empVO = companyMapper.getEmp("KING");
        
        log.warn("queried by UserVO mapper: " + user); // 사용자 정보를 로그에 기록.
        
        // 사용자 정보가 존재하는 경우 해당 정보를 바탕으로 UserDetailsVO 객체를 생성하여 반환하고, 사용자 정보가 없는 경우에는 null을 반환합니다.
        return user == null ? null : new UserDetailsVO(user,empVO);
    }
}



