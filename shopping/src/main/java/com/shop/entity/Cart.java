package com.shop.entity;

import net.sf.json.JSONObject;

/**
 * 购物车实体类
 * @author hdd
 */
public class Cart {
	private int cart_id;
	private int user_id;
	
	public Cart() {
		
	}
	public Cart(int user_id) {
		this.user_id = user_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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
