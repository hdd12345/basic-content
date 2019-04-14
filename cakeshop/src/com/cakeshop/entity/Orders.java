package com.cakeshop.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class Orders {
    private String orders_id;

    private String orders_num;

    private Double orders_total_price;

    private Date orders_time;

    private String orders_state;

    private String user_id;

    private String address_id;

	public String getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(String orders_id) {
		this.orders_id = orders_id;
	}

	public String getOrders_num() {
		return orders_num;
	}

	public void setOrders_num(String orders_num) {
		this.orders_num = orders_num;
	}

	public Date getOrders_time() {
		return orders_time;
	}

	public void setOrders_time(Date orders_time) {
		this.orders_time = orders_time;
	}

	public String getOrders_state() {
		return orders_state;
	}

	public void setOrders_state(String orders_state) {
		this.orders_state = orders_state;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public Double getOrders_total_price() {
		return orders_total_price;
	}

	public void setOrders_total_price(Double orders_total_price) {
		this.orders_total_price = orders_total_price;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}