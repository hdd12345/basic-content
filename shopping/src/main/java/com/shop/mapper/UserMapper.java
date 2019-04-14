package com.shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.entity.User;
@Repository("userMapper")
public interface UserMapper {
	//添加用户
	public int insertUser(User user) throws Exception;
	//查询用户
	public User selectUser(User user) throws Exception;
	//根据id删除用户
	public int deleteUserByid(int user_id) throws Exception;
	//查询所有用户
	public List<User> selectAllUser() throws Exception;
	//修改用户信息
	public int updateUser(User user) throws Exception;
	//根据用户名查询用户
	public User selectUserByUsername(String username);
	//根据用户id查询用户
	public User selectUserByUser_id(int user_id) throws Exception;
}
