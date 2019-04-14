package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Cart;
import com.shop.entity.Cart_items;
import com.shop.entity.User;
import com.shop.mapper.CartMapper;
import com.shop.mapper.Cart_itemsMapper;
import com.shop.mapper.GoodsMapper;
import com.shop.service.CartService;

@Service("cartServiceImpl")
public class CartServiceImpl implements CartService{
	@Resource(name="cartMapper")
	private CartMapper cartMapper;
	@Resource(name="cart_itemsMapper")
	private Cart_itemsMapper cart_itemsMapper;
	@Resource(name="goodsMapper")
	private GoodsMapper goodsMapper;
	
	/**
	 * 查询购物车明细
	 */
	@Override
	public List<Cart_items> selectCart_items(int cart_id) throws Exception {
		return cart_itemsMapper.selectAllCart_items(cart_id);
	}
	
	/**
	 * 添加购物车明细，即添加商品到购物车
	 * 根据该条明细数量及对应的商品单价计算该条明细总价，再插入数据库
	 */
	@Override
	public int insertCart_items(Cart_items cart_items) throws Exception {
		cart_items.setTotal_price(cart_items.getQuantity()*goodsMapper.selectGoodsByGoods_id(cart_items.getGoods_id()).getPrice());
		return cart_itemsMapper.insertCart_items(cart_items);
	}
	
	/**
	 * 删除购物车明细
	 */
	@Override
	public int deleteCart_items(int cart_items_id) throws Exception {
		return cart_itemsMapper.deleteCart_items(cart_items_id);
	}
	
	/**
	 * 根据用户查询购物车
	 */
	@Override
	public Cart selectCartByUser(User user) throws Exception {
		return cartMapper.selectCartByUser_id(user.getUser_id());
	}
	
	/**
	 * 批量删除购物车明细
	 */
	@Override
	public int deleteManyCart_items(int[] cart_items_id) throws Exception {
		return cart_itemsMapper.deleteManyCart_items(cart_items_id);
	}

}
