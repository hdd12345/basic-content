package com.hdd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alibaba.fastjson.JSONObject;

@Entity
@Table(name="phone")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Phone{
	private int id;
	private String name;
	private String phonesize;
	private int user_id;
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	//inserttable和updatetable设置成false，表示不保存到数据库
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id
	@GeneratedValue
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
	
	@Column(name="user_id")
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.toJSONString(this);
	}
	
}
