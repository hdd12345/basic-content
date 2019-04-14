package com.cakeshop.entity;

import com.alibaba.fastjson.JSONObject;

public class Cartitem {
    private String cartitem_id;

    private Integer quantity;

    private String cart_id;

    private String goods_id;

	public String getCartitem_id() {
		return cartitem_id;
	}

	public void setCartitem_id(String cartitem_id) {
		this.cartitem_id = cartitem_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}