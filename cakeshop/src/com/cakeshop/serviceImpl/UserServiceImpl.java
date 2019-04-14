package com.cakeshop.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cakeshop.entity.Cart;
import com.cakeshop.entity.User;
import com.cakeshop.mapper.CartMapper;
import com.cakeshop.mapper.UserMapper;
import com.cakeshop.service.UserService;
import com.cakeshop.util.CommonUtil;
import com.cakeshop.util.MD5Utils;
import com.cakeshop.util.MailUtils;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
   @Resource(name="userMapper")
   private UserMapper userMapper;
   @Resource(name="cartMapper")
   private CartMapper cartMapper;
   
	@Override
	public int insertUser(User user) throws Exception {
		String uuid = CommonUtil.getUUID();
		user.setUser_id(CommonUtil.getUUID());
		user.setCode(uuid);
		user.setPassword(MD5Utils.md5(user.getPassword()));
		if(userMapper.insertUser(user)==1){
		MailUtils.sendMail(user.getEmail(),uuid);
		Cart cart = new Cart();
		cart.setCart_id(CommonUtil.getUUID());
		cart.setUser_id(user.getUser_id());
		cartMapper.insertCart(cart);
		return 1;
		}
		return 0;
	}

	@Override
	public User selectUser(User user) throws Exception {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return userMapper.selectUser(user);
	}

	@Override
	public int selectUserName(String username) throws Exception {
		User user = userMapper.selectUserName(username);
		if(user!=null){
			return 1;
		}
		return 0;
	}

	@Override
	public int updateState(String code) throws Exception {
	
			return userMapper.updateState(code);
		
		
	}

	@Override
	public int updateUser(User user) throws Exception {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return userMapper.updateUser(user);
	}

	@Override
	public int selectUserNameLogin(String username) throws Exception {
		User user = userMapper.selectUserName(username);
		if(user==null){
			return 0;
			}
		MailUtils.sendMail(user.getEmail(),user.getCode());
		return 1;
	}

	@Override
	public int resetPassword(String code) throws Exception {
		if(userMapper.updatePassword(code)!=0){
			return 1;
		}
		
		return 0;
	}

}
