package com.cakeshop.service;

import com.cakeshop.entity.User;

public interface UserService {
	// 新增用户
	public int insertUser(User user) throws Exception;

	// 查询用户（用于登录）
	public User selectUser(User user) throws Exception;

	// 查询用户名（用于用户名查重）
	public int selectUserName(String username) throws Exception;

	// 改变用户状态（主要用于用户账号激活）
	public int updateState(String code) throws Exception;

	// 更新用户密码
	public int updateUser(User user) throws Exception;

	// 查询用户（用于忘记密码）
	public int selectUserNameLogin(String username) throws Exception;

	// 重置密码（用于忘记密码）
	public int resetPassword(String code) throws Exception;

}
