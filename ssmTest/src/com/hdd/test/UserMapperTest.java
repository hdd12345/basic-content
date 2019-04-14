package com.hdd.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdd.mapper.UserMapper;
import com.hdd.entity.User;

public class UserMapperTest {
	//@Resource(name="userMapper")
	@Autowired
	private UserMapper userMapper;
	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//根据id查询用户
	@Test
	public void findUserById() throws Exception {
		System.out.println("哈哈哈");
		UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.selectUserById(1);
        System.out.println(user.toString());
	}
	//添加用户
	@Test
	public void insertUser() throws Exception {
		UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = new User();
        user.setUsername("test2");
        user.setPassword("123");
        System.out.println(user.toString());
        userMapper.insertUser(user);
	}
	
	//删除用户
	@Test
	public void deleteUser() throws Exception {
		UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        userMapper.deleteUserByid(13);
        System.out.println("123");
	}
	
	//查询所有用户
	@Test
	public void selectAllUser() throws Exception{
		UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
		List<User> list = userMapper.selectAllUser();
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	//修改用户信息
	@Test
	public void updateUser() throws Exception{
		UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
		User user = new User();
		user.setId(1);
        user.setUsername("abcd");
        user.setPassword("1234");
		userMapper.updateUser(user);
	}
	
	//多个参数注解写法测试
	@Test
	public void update() throws Exception{
		UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
		userMapper.update1("abcde","123");
	}
	
	@Test
	public void test() throws Exception {
		UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
		System.out.println(userMapper.selectTest());
	}

}
