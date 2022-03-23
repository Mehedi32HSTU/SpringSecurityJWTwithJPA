package com.spring.rest.models;

//package com.spring.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String userName;
	private String password;
	private String roles;
	private boolean isActive;
	
	public User() {
		
	}
	public User(String userName, String password, String roles, boolean isActive) {
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.isActive = isActive;
	}
	public Long getId() {
		return Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", userName=" + userName + ", password=" + password + ", roles=" + roles
				+ ", isActive=" + isActive + "]";
	}
	


}
