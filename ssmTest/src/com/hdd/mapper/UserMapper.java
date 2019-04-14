package com.hdd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hdd.entity.User;
@Repository("userMapper")
public interface UserMapper {
	//添加用户
	public void insertUser(User user) throws Exception;
	//根据id查询用户
	public User selectUserById(int id) throws Exception;
	//根据id删除用户
	public void deleteUserByid(int id) throws Exception;
	//查询所有用户
	public List<User> selectAllUser() throws Exception;
	//修改用户信息
	public void updateUser(User user) throws Exception;
	//多个参数
	public void update1(@Param("uuu") String username,@Param("ppp") String password) throws Exception;
	public String selectTest() throws Exception;
}
