package com.cakeshop.serviceImpl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cakeshop.entity.Cartitem;
import com.cakeshop.entity.CartitemInfo;
import com.cakeshop.mapper.CartMapper;
import com.cakeshop.mapper.CartitemMapper;
import com.cakeshop.service.CartService;
@Service("cartServiceImpl")
public class CartServiceImpl implements CartService {
	
	@Resource(name="cartMapper")
	CartMapper cartMapper;
	@Resource(name="cartitemMapper")
	CartitemMapper cartitemMapper;
	
	/**
	 * 根据用户id查询购物车明细：先根据用户id查询购物车，再根据购物车id查询购物车明细以及对应的商品信息
	 */
	@Override
	public List<CartitemInfo> selectCartitemByUser_id(String user_id) throws Exception {
		String cart_id = cartMapper.selectCartByUser_id(user_id).getCart_id();
		return cartitemMapper.selectByCart_id(cart_id);
	}
	
	/**
	 * 批量删除购物车明细
	 */
	@Override
	public int deleteCartitem(String[] cartitem_ids) throws Exception {
		return cartitemMapper.deleteCartitems(cartitem_ids);
	}
	
	/**
	 * 添加购物车明细
	 */
	@Override
	public int insertCartitem(Cartitem cartitem,String user_id) throws Exception {
		String cart_id = cartMapper.selectCartByUser_id(user_id).getCart_id();
		cartitem.setCart_id(cart_id);
		cartitem.setCartitem_id(UUID.randomUUID().toString().replace("-",""));
		return cartitemMapper.insertCartitem(cartitem);
	}
	
	/**
	 * 修改购物车明细（主要用于修改数量）
	 */
	@Override
	public int updateCartitem(Cartitem cartitem) throws Exception {
		return cartitemMapper.updateCartitem(cartitem);
	}
	
	
}
