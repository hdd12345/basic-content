package com.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.entity.Cart_items;
import com.shop.entity.MyList;
import com.shop.service.CartService;
import com.shop.service.OrdersService;

@RequestMapping(value="/cart")
@Controller
public class CartController {
	@Resource(name="cartServiceImpl")
	private CartService cartService;
	@Resource(name="ordersServiceImpl")
	OrdersService ordersService;
	
	/**
	 * 查询购物车中商品
	 * @param cart_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCart_items",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Cart_items> selectCart_items(@RequestParam int cart_id) throws Exception{
		return cartService.selectCart_items(cart_id);
	}
	
	/**
	 * 添加购物车明细，即添加商品到购物车
	 * @param cart_items
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertCart_items",method=RequestMethod.POST)
	@ResponseBody
	public int insertCart_items(@RequestBody Cart_items cart_items) throws Exception{
		return cartService.insertCart_items(cart_items);
	}
	
	/**
	 * 删除购物车中商品
	 * @param cart_items_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCart_items",method=RequestMethod.POST)
	@ResponseBody
	public int deleteCart_items(@RequestParam int cart_items_id) throws Exception{
		return cartService.deleteCart_items(cart_items_id);
	}
	
	/**
	 * 结算购物车（计算已选总价并批量生成订单及订单明细）
	 * @param cart_items_ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/settlementCart",method=RequestMethod.POST)
	@ResponseBody
	public int settlementCart(@RequestBody MyList myList) throws Exception{
		return ordersService.insertManyOrders(myList);
	}
	
	/**
	 * 批量删除购物车中商品
	 * @param cart_items_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteManyCart_items",method=RequestMethod.POST)
	@ResponseBody
	public int deleteManyCart_items(@RequestParam int[] cart_items_id) throws Exception{
		return cartService.deleteManyCart_items(cart_items_id);
	}
}
