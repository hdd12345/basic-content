package com.shop.controller;

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

import com.shop.entity.Address;
import com.shop.entity.User;
import com.shop.service.CartService;
import com.shop.service.UserService;
@RequestMapping(value="/user")
@Controller
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	@Resource(name="cartServiceImpl")
	private CartService cartService;
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public int register(@RequestBody User user) throws Exception{
		return userService.register(user);
	};
	
	/**
	 * 用户登录
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public int login(@RequestBody User user,HttpSession session) throws Exception {
		User user1 = userService.login(user);
		if(user1!=null) {
			session.setAttribute("user",user1);
			session.setAttribute("cart",cartService.selectCartByUser(user1));
			return 1;
		}
		return 0;
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	@ResponseBody
	public int logout(HttpSession session) {
		//清除session
		session.invalidate();
		return 1;
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public int updateUser(@RequestBody User user) throws Exception{
		return userService.updateUser(user);
	}
	
	/**
	 * 检测用户名是否存在
	 * @param username
	 * @return 1为用户名已存在，0为不存在
	 * @throws Exception
	 */
	@RequestMapping(value="/testUsername",method= {RequestMethod.POST,RequestMethod.POST})
	@ResponseBody
	public int testUsername(@RequestParam String username) throws Exception {
		if(userService.selectUserByUsername(username)!=null) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * 添加收货地址
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertAddress",method=RequestMethod.POST)
	@ResponseBody
	public int insertAddress(@RequestBody Address address) throws Exception{
		return userService.insertAddress(address);
	}
	
	/**
	 * 修改收货地址
	 * @param address
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateAddress",method=RequestMethod.POST)
	@ResponseBody
	public int updateAddress(@RequestBody Address address) throws Exception{
		return userService.updateAddress(address);
	}
	
	/**
	 * 删除收货地址
	 * @param address_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAddress",method=RequestMethod.POST)
	@ResponseBody
	public int deleteAddressById(@RequestParam int address_id)throws Exception{
		return userService.deleteAddressById(address_id);
	}
	
	/**
	 * 查看收货地址
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/showAddress",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<Address> showAddress(@RequestParam int user_id,HttpServletRequest request) throws Exception{
		return userService.showAddress(user_id);
	}
}
