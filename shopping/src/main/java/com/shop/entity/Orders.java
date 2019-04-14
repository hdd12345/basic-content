package com.shop.entity;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
/**
 * 订单类
 * @author hdd
 */
public class Orders {
	private int orders_id;
	private String orders_num;
	private double orders_total_price;
	private Date orders_time;
	private int user_id;
	private int shop_id;
	private int address_id;
	private String orders_state;
	//以下为扩展属性，用于关联查询
	private List<Orders_detail> orders_detail_list;
	
	public List<Orders_detail> getOrders_detail_list() {
		return orders_detail_list;
	}
	public void setOrders_detail_list(List<Orders_detail> orders_detail_list) {
		this.orders_detail_list = orders_detail_list;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public String getOrders_num() {
		return orders_num;
	}
	public void setOrders_num(String orders_num) {
		this.orders_num = orders_num;
	}
	public double getOrders_total_price() {
		return orders_total_price;
	}
	public void setOrders_total_price(double orders_total_price) {
		this.orders_total_price = orders_total_price;
	}
	public Date getOrders_time() {
		return orders_time;
	}
	public void setOrders_time(Date orders_time) {
		this.orders_time = orders_time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getOrders_state() {
		return orders_state;
	}
	public void setOrders_state(String orders_state) {
		this.orders_state = orders_state;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.fromObject(this).toString();
	}
}
