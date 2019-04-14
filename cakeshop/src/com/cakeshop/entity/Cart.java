package com.cakeshop.entity;

import com.alibaba.fastjson.JSONObject;

public class Cart {
    private String cart_id;

    private String user_id;

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
    
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}