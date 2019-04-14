package com.cakeshop.entity;

import com.alibaba.fastjson.JSONObject;
/**
 * 扩展类：用于关联查询输出映射
 * @author Administrator
 *
 */
public class CartitemInfo extends Cartitem{
	private String cartitem_id;

    private Integer quantity;

    private String cart_id;

    private String goods_id;
    //以下为扩展属性
    private Goods goods;

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

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
    
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
