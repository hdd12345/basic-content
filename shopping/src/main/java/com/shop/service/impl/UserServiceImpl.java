package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Address;
import com.shop.entity.Cart;
import com.shop.entity.User;
import com.shop.mapper.AddressMapper;
import com.shop.mapper.CartMapper;
import com.shop.mapper.UserMapper;
import com.shop.service.UserService;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource(name="userMapper")
	private UserMapper userMapper;
	@Resource(name="cartMapper")
	private CartMapper cartMapper;
	@Resource(name="addressMapper")
	private AddressMapper addressMapper;

	@Override
	public int register(User user) throws Exception {
		userMapper.insertUser(user);
		return cartMapper.insertCart(new Cart(user.getUser_id()));
	}

	@Override
	public User login(User user) throws Exception {
		return userMapper.selectUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return userMapper.updateUser(user);
	}
	
	@Override
	public User selectUserByUsername(String username) throws Exception {
		return userMapper.selectUserByUsername(username);
	}

	@Override
	public int insertAddress(Address address) throws Exception {
		return addressMapper.insertAddress(address);
	}

	@Override
	public int updateAddress(Address address) throws Exception {
		return addressMapper.updateAddress(address);
	}

	@Override
	public int deleteAddressById(int address_id) throws Exception {
		return addressMapper.deleteAddressById(address_id);
	}

	@Override
	public List<Address> showAddress(int user_id) throws Exception {
		return addressMapper.selectAddressByUser_id(user_id);
	}
	
}
