package com.shop.entity;

import net.sf.json.JSONObject;

/**
 * 商品图片类
 * @author Administrator
 */
public class Goods_img {
	private int goods_img_id;
	private String goods_img_name;
	private int goods_id;
	public int getGoods_img_id() {
		return goods_img_id;
	}
	public void setGoods_img_id(int goods_img_id) {
		this.goods_img_id = goods_img_id;
	}
	public String getGoods_img_name() {
		return goods_img_name;
	}
	public void setGoods_img_name(String goods_img_name) {
		this.goods_img_name = goods_img_name;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.fromObject(this).toString();
	}
}
