package com.revature.pojo;

public class User {
	
	private String username;

	private String password;
	
	private int id;
	
	

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
	

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public void deposit(int amount) {
		// TODO Auto-generated method stub
		
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}
