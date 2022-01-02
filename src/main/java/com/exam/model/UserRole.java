package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	private User users;

	@ManyToOne
	private Role roles;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(long userRoleId, User users, Role roles) {
		super();
		this.userRoleId = userRoleId;
		this.users = users;
		this.roles = roles;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", users=" + users + ", roles=" + roles + "]";
	}

}
