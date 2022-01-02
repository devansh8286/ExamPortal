package com.exam.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {



	private static final long serialVersionUID = 1L;
	
	private String authority;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

	@Override
	public String toString() {
		return "Authority [authority=" + authority + "]";
	}

	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
