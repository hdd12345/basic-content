package com.hdd.entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class User {
	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String toString() {
		// TODO Auto-generated method stub
		return "[id:"+this.id+",username:"+this.username+",password:"+this.password+"]";
	}


	
}
