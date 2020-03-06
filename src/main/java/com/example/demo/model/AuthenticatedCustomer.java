package com.example.demo.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedCustomer implements UserDetails {
	private String username;
	private String password;
	private String token;
	private Long id;
	
	public AuthenticatedCustomer() {}
	
	
	public AuthenticatedCustomer(String username, Long id, String token) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public AuthenticatedCustomer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}



}
