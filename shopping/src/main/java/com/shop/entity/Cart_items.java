package com.shop.entity;

import net.sf.json.JSONObject;

/**
 * 购物车明细类，即购物车中存放的每一个商品
 * @author Administrator
 */
public class Cart_items {
	private int cart_items_id;
	private int cart_id;
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
	public int getCart_items_id() {
		return cart_items_id;
	}
	public void setCart_items_id(int cart_items_id) {
		this.cart_items_id = cart_items_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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
