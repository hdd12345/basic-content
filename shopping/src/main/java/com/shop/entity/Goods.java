package com.shop.entity;

import java.util.List;

import net.sf.json.JSONObject;

/**
 * 商品类
 * @author hdd
 */
public class Goods {
	private int goods_id;
	private String goods_num;
	private String goods_name;
	private double price;
	private String detail;
	private int number;
	private String goods_type;
	private int shop_id;
	//以下为扩展属性，用于关联查询
	private List<Goods_img> list_goods_img;
	public List<Goods_img> getList_goods_img() {
		return list_goods_img;
	}
	public void setList_goods_img(List<Goods_img> list_goods_img) {
		this.list_goods_img = list_goods_img;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(String goods_num) {
		this.goods_num = goods_num;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.fromObject(this).toString();
	}
}
