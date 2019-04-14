package com.hdd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdd.entity.User;
import com.hdd.mapper.UserMapper;
import com.hdd.service.UserService;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource(name="userMapper")
	private UserMapper userMapper;
	@Override
	public User findUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(id);
	}
	
}
