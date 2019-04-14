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
	 * ��ӹ��ﳵ��ϸ��������Ʒ���빺�ﳵ
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
		return -1;//��ǰ�û������ڷ���-1������¼������ִ�д˲�����
	}
	
	/**
	 * ��ȡ���ﳵ��ϸ�б�
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
	 * ����ɾ�����ﳵ��ϸ
	 * @param ids ���ﳵ��ϸid������ַ������Զ��ŷָ�
	 * @return ɾ��������
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/deleteCartitem",method=RequestMethod.POST)
	public int deleteCartitem(@RequestParam String ids) throws Exception{
		String [] cartitem_ids = ids.split(",");
		return cartService.deleteCartitem(cartitem_ids);
	}
	
	/**
	 * �޸Ĺ��ﳵ��ϸ
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
