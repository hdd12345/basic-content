package com.shop.test.mapper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Cart;
import com.shop.mapper.CartMapper;

public class CartMapperTest {
	private ApplicationContext ac;
	private CartMapper cartMapper;
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		cartMapper = (CartMapper)ac.getBean("cartMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertCart() throws Exception {
//		Cart cart = new Cart();
//		cart.setUser_id(3);
//		System.out.println(cartMapper.insertCart(cart));
	}
	
	@Test
	public void testSelectCartByUser_id() throws Exception{
		System.out.println(cartMapper.selectCartByUser_id(3));
	}

}
