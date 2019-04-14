package com.cakeshop.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.User;
import com.cakeshop.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserMapperTest {

	@Resource(name = "userMapper")
	public UserMapper userMapper;

	@Test
	public void testInsertUser() throws Exception {
		/*
		 * User user = new User(); user.setUser_id("1");
		 * user.setUsername("ahuang"); user.setPassword("12213");
		 * user.setName("213213"); user.setEmail("wqewqewq");
		 * user.setTelephone("1232132123"); user.setSex("nv"); user.setState(0);
		 * user.setCode("123"); user.setUser_img("wqeqwew");
		 * System.out.println(userMapper.insertUser(user));
		 */
	}

	@Test
	public void testSelectUser() throws Exception {
		// User user = new User();
		// user.setUsername("ahuang");
		// user.setPassword("12213");
		// System.out.println(userMapper.selectUser(user));
	}

	@Test
	public void testSelectUserName() throws Exception {
		/*
		 * User user = new User();
		 * 
		 * System.out.println(userMapper.selectUserName("qwewqe"));
		 */
	}

	@Test
	public void testUpdateState() throws Exception {
		/*
		 * User user = new User();
		 * System.out.println(userMapper.updateState("213qwe"));
		 */
	}

	@Test
	public void testUpdateUser() throws Exception {
		/*
		 * User user = new User(); user.setUser_id("1");
		 * user.setUsername("qwewqe"); user.setPassword("12321");
		 * user.setName("21313"); user.setEmail("wqew123wq");
		 * user.setTelephone("1232123"); user.setSex("132v"); user.setState(3);
		 * user.setCode("213qwe"); user.setUser_img("qwewew");
		 * System.out.println(userMapper.updateUser(user));
		 */
	}

}
