package com.shop.mapper;

import org.springframework.stereotype.Repository;

import com.shop.entity.Cart;

@Repository("cartMapper")
public interface CartMapper {
	//添加购物车
	public int insertCart(Cart cart) throws Exception;
	//根据用户id查询购物车
	public Cart selectCartByUser_id(int user_id) throws Exception;
}
