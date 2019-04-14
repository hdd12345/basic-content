package com.hdd.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.alibaba.fastjson.JSONObject;

@Entity
@Table(name="user")
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class User {
	private int id;
	private String username;
	private String password;
	private Set<Phone> phoneList;
	
	//mappedBy:指定维护关系的一方，fetch=FetchType.LAZY：懒加载
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	//根据获取值的不同来使用不同的sql语句
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Phone> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(Set<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	
	@Id
	@GeneratedValue
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
		return JSONObject.toJSONString(this);
	}
	
	
}
