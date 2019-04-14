package com.hdd.entity;

import java.io.Serializable;

public class Phone implements Serializable{
	private int id;
	private String name;
	private String phonesize;
	private int user_id;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonesize() {
		return phonesize;
	}
	public void setPhonesize(String phonesize) {
		this.phonesize = phonesize;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[id:"+this.id+",name:"+this.name+",phonesize:"+this.phonesize+"]"+this.user.toString();
	}
	
}
