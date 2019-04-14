package com.shop.test.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.entity.User;
import com.shop.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserMapperTest {
	
	@Resource(name="userMapper")
	private UserMapper userMapper;

	@Test
	public void testInsertUser() throws Exception {
//		User user = new User();
//		user.setUsername("翠花3");
//		user.setLogin_pwd("123456");
//		user.setPhone_num("119");
//		user.setPay_pwd("123456");
//		user.setSex("女");
//		userMapper.insertUser(user);
	}

	@Test
	public void testSelectUser() throws Exception {
		User user = new User();
		user.setUsername("翠花");
		user.setLogin_pwd("123456");
		System.out.println(userMapper.selectUser(user));
	}

	@Test
	public void testDeleteUserByid() throws Exception {
//		System.out.println(userMapper.deleteUserByid(6));
	}

	@Test
	public void testSelectAllUser() throws Exception {
		List<User> list = userMapper.selectAllUser();
		for(User user:list) {
			System.out.println(user);
		}
	}

	@Test
	public void testUpdateUser() throws Exception {
		User user = new User();
		user.setUser_id(5);
		user.setLogin_pwd("123455");
		user.setPhone_num("911");
		user.setBalance(0);
		user.setPay_pwd("123455");
		user.setUsername("豆花");
		user.setUser_type(1);
		user.setImage("timor");
		user.setSex("女");
		System.out.println(userMapper.updateUser(user));
	}

	@Test
	public void testSelectUserByUsername() {
		System.out.println(userMapper.selectUserByUsername("豆花"));
	}
	
	@Test
	public void testSelectUserByUser_id() throws Exception {
		System.out.println(userMapper.selectUserByUser_id(3));
	}

}
