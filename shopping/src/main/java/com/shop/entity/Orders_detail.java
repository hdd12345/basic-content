package com.shop.entity;

import net.sf.json.JSONObject;

/**
 * 订单明细类
 * @author hdd
 */
public class Orders_detail {
	private int orders_detail_id;
	private int orders_id;
	private int goods_id;
	private int quantity;
	private double total_price;
	//以下为扩展属性，用于关联查询
	private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getOrders_detail_id() {
		return orders_detail_id;
	}
	public void setOrders_detail_id(int orders_detail_id) {
		this.orders_detail_id = orders_detail_id;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.fromObject(this).toString();
	}
}
