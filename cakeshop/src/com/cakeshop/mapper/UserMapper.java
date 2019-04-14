package com.cakeshop.mapper;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.User;

public interface UserMapper {
	// 新增用户
	public int insertUser(User user) throws Exception;

	// 查询用户（用于登录）
	public User selectUser(User user) throws Exception;

	// 查询用户名（用于用户名查重,忘记密码获取user对象）
	public User selectUserName(String username) throws Exception;

	// 改变用户状态（主要用于用户账号激活）
	public int updateState(String code) throws Exception;

	// 更新用户
	public int updateUser(User user) throws Exception;

	// 重置密码为123456
	public int updatePassword(String code) throws Exception;

}