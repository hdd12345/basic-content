package com.shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.entity.Cart_items;

@Repository("cart_itemsMapper")
public interface Cart_itemsMapper {
	//添加购物车明细（即添加商品到购物车）
	public int insertCart_items(Cart_items cart_items) throws Exception;
	//删除购物车明细
	public int deleteCart_items(int cart_items_id) throws Exception;
	//批量删除购物车明细
	public int deleteManyCart_items(int[] cart_items_id) throws Exception;
	//修改购物车明细
	public int updateCart_items(Cart_items cart_items) throws Exception;
	//查询购物车中所有商品（关联查询）
	public List<Cart_items> selectAllCart_items(int cart_id) throws Exception;
	//根据id查询购物车明细
	public List<Cart_items> selectCart_items(int[] cart_items_id) throws Exception;
}
