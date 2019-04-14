package com.shop.service;

import java.util.List;

import com.shop.entity.Cart;
import com.shop.entity.Cart_items;
import com.shop.entity.User;

public interface CartService {
	//查询购物车中商品
	public List<Cart_items> selectCart_items(int cart_id) throws Exception;
	//根据用户查询购物车
	public Cart selectCartByUser(User user) throws Exception;
	//添加商品到购物车
	public int insertCart_items(Cart_items cart_items) throws Exception;
	//删除购物车中商品
	public int deleteCart_items(int cart_items_id) throws Exception;
	//批量删除购物车中商品
	public int deleteManyCart_items(int[] cart_items_id) throws Exception;
}
