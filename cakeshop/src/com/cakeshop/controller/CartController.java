package com.cakeshop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cakeshop.entity.Cartitem;
import com.cakeshop.entity.CartitemInfo;
import com.cakeshop.entity.User;
import com.cakeshop.service.CartService;
@RequestMapping(value="/cart")
@Controller
public class CartController {
	
	@Resource(name="cartServiceImpl")
	private CartService cartService;
	
	/**
	 * 添加购物车明细：即将商品加入购物车
	 * @param cartitem
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/addCartitem",method=RequestMethod.POST)
	public int addCartitem(@RequestParam int quantity,
			@RequestParam String goods_id,HttpServletRequest request) throws Exception{
		User user = (User)request.getSession().getAttribute("user");
		if(user!=null){
			String user_id = user.getUser_id();
			Cartitem cartitem = new Cartitem();
			cartitem.setGoods_id(goods_id);
			cartitem.setQuantity(quantity);
			return cartService.insertCartitem(cartitem,user_id);
		}
		return -1;//当前用户不存在返回-1（不登录不允许执行此操作）
	}
	
	/**
	 * 获取购物车明细列表
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/getCartitemList",method={RequestMethod.POST,RequestMethod.GET})
	public List<CartitemInfo> getCartitemList(HttpSession session) throws Exception{
		User user = (User)session.getAttribute("user");
		String user_id = user.getUser_id();
		return cartService.selectCartitemByUser_id(user_id);
	}
	
	/**
	 * 批量删除购物车明细
	 * @param ids 购物车明细id的组合字符串，以逗号分隔
	 * @return 删除的条数
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/deleteCartitem",method=RequestMethod.POST)
	public int deleteCartitem(@RequestParam String ids) throws Exception{
		String [] cartitem_ids = ids.split(",");
		return cartService.deleteCartitem(cartitem_ids);
	}
	
	/**
	 * 修改购物车明细
	 * @param cartitem
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/updateCartitem",method=RequestMethod.POST)
	public int updateCartitem(@RequestBody Cartitem cartitem) throws Exception{
		return cartService.updateCartitem(cartitem);
	}
}
