package com.cakeshop.mapper;

import java.util.List;

import com.cakeshop.entity.Cartitem;
import com.cakeshop.entity.CartitemInfo;

public interface CartitemMapper {
    //根据购物车id查询购物车明细（关联查询：结果集中包含购物车明细及商品信息）
	public List<CartitemInfo> selectByCart_id(String cart_id) throws Exception;
	//删除购物车明细（可批量）
	public int deleteCartitems(String [] cartitem_ids) throws Exception;
	//添加购物车明细
	public int insertCartitem(Cartitem cartitem) throws Exception;
	//修改购物车明细
	public int updateCartitem(Cartitem cartitem) throws Exception;
	//根据购物车明细id查询购物车明细
	public CartitemInfo selectByCartitem_id(String cartitem_id) throws Exception;
}