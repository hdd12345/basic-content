package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.entity.Address;
import com.shop.entity.User;

public interface UserService {
	//用户注册
	public int register(User user) throws Exception;
	//用户登录
	public User login(User user) throws Exception;
	//修改用户信息
	public int updateUser(User user) throws Exception;
	//根据用户名查询用户
	public User selectUserByUsername(String username) throws Exception;
	//添加收货地址
	public int insertAddress(Address address) throws Exception;
	//修改收货地址
	public int updateAddress(Address address) throws Exception;
	//删除收货地址
	public int deleteAddressById(int address_id) throws Exception;
	//查看收货地址
	public List<Address> showAddress(int user_id) throws Exception;
}
