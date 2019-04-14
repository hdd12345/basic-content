package com.cakeshop.mapper;

import com.cakeshop.entity.Cart;

public interface CartMapper {
	//添加购物车
	public int insertCart(Cart cart) throws Exception;
	//根据用户id查询购物车
	public Cart selectCartByUser_id(String user_id) throws Exception;
	//根据用户id查询购物车及购物车明细（关联查询：包含购物车信息、购物车明细信息、商品信息）
}