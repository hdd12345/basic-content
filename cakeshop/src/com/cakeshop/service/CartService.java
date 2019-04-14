package com.cakeshop.service;

import java.util.List;

import com.cakeshop.entity.Cartitem;
import com.cakeshop.entity.CartitemInfo;

public interface CartService {
	//根据用户id查询购物车明细（包含商品信息）
	public List<CartitemInfo> selectCartitemByUser_id(String user_id) throws Exception;
	//批量删除购物车明细
	public int deleteCartitem(String [] cartitem_ids) throws Exception;
	//添加购物车明细
	public int insertCartitem(Cartitem cartitem,String user_id) throws Exception;
	//修改购物车明细：主要用于修改数量
	public int updateCartitem(Cartitem cartitem) throws Exception;
}
