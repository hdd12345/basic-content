package com.shop.entity;

import java.sql.Date;

import net.sf.json.JSONObject;
/**
 * 店铺类
 * @author Administrator
 */
public class Shop {
	private int shop_id;
	private String shop_name;
	private Date build_time;
	private int user_id;
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public Date getBuild_time() {
		return build_time;
	}
	public void setBuild_time(Date build_time) {
		this.build_time = build_time;
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
