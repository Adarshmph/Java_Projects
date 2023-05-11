//package com.example.test.demo.principle;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.test.demo.models.Employee;
//
//public class UserPrinciple implements UserDetails {
//
//	private Employee emp;
//	
//	public UserPrinciple(Employee emp) {
//		super();
//		this.emp = emp;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return Collections.singleton(new SimpleGrantedAuthority("EMPLOYEE"));
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return emp.getPass();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return emp.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
