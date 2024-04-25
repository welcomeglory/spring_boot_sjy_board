package edu.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class UserDetailsVO implements UserDetails{
	//UserDetails은 섹션영역에 저장됨
	// 섹션 30분동안 메모리 영역에 저장
	//ex)form:사용자정보를 양식에 맞게 저장
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	//테스트=====================================================
	private String email = "admin@admin.com";
	private EmpVO emp = new EmpVO();
	private CartVO cart = new CartVO(); //보통 쇼핑몰화면에서 로그인을 하면 카트(장바구니)가 보인다.
	
	public CartVO getCart() {
		return this.cart;
	}

	public EmpVO getEmp() {
		return this.emp;
	}
	
	public String getEmail() {
		return this.email;
	}
	//==========================================================
	
	public UserDetailsVO(UserVO user, EmpVO empVO) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(user);
		
		this.emp = empVO;
	}
	
	public void setAuthorities(UserVO userVO) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(AuthVO authVO : userVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(authVO.getAuthority()));
		}
		this.authorities = authorities;
	} 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	//계정이 만료되지 않았는가?
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//계정이 잠기지 않았는가?
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//패스워드가 만료되지 않았는가?
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
   // 계정이 활성화 되었는가?
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
