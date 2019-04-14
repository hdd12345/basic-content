package com.shop.entity;

import net.sf.json.JSONObject;

/**
 * 收货地址实体类
 * @author hdd
 */
public class Address {
	private int address_id;
	private String name;
	private String phone_num;
	private String postcode;
	private String address_content;
	private int user_id;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress_content() {
		return address_content;
	}
	public void setAddress_content(String adderss_content) {
		this.address_content = adderss_content;
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
		return JSONObject.fromObject(this).toString();
	}
}

