package edu.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {
   
   @Autowired
   private UserMapper userMapper;
   
   @Test
   void testUserMapper() {
      assertNotNull(userMapper);
   }
   
   @Test
   void testGetUser() {
      UserVO user = userMapper.getUser("admin");
      assertNotNull(user);
      
      System.out.println(user);
   }
   @Test
   void testInsertUser() {
      UserVO user = new UserVO();
      user.setUsername("admin3");
      user.setPassword(new BCryptPasswordEncoder().encode("admin3"));
      user.setEnabled("1");
      
      userMapper.insertUser(user);
      userMapper.insertAuthoruties(user);
      
      
      
   }
   

}