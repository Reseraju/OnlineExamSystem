package com.hexaware.OnlineExamSystem.Model;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@Column
	@GeneratedValue
	private int UserId;
	@Column(unique = true, nullable = false)
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private boolean Active;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		this.Active = active;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", Active=" + Active + "]";
	}
	
	
}
