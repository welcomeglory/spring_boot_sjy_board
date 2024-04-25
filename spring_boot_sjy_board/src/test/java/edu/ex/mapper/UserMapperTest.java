package edu.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.ex.vo.BoardVO;
import edu.ex.vo.EmpVO;
import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class UserMapperTest {
   
   @Autowired
   private UserMapper userMapper;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   @Autowired
	private CompanyMapper companyMapper;
   
   @Disabled
   @Test
   void testUserMapper() {
      assertNotNull(userMapper);
   }
   @Disabled
   @Test
   void testGetUser() {
      UserVO user = userMapper.getUser("admin");
      assertNotNull(user);
      
      System.out.println(user);
   }
   
  @Disabled
   @Test
   void testInsertUser() {
      UserVO user = new UserVO();
      user.setUsername("admin3");
      user.setPassword(new BCryptPasswordEncoder().encode("admin3"));
      user.setEnabled("1");
      
      userMapper.insertUser(user);
      userMapper.insertAuthoruties(user);  	  
      
   }

  @Test
   void testMatcher() {
      UserVO user = userMapper.getUser("admin2");
      boolean isMatch = passwordEncoder.matches("admin2", user.getPassword());
      assertEquals(isMatch, true);
	      
   }
  
}