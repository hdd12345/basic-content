package com.cakeshop.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.Cart;
import com.cakeshop.mapper.CartMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class CartMapperTest {
	
	@Resource(name="cartMapper")
	CartMapper cartMapper;
	
	@Test
	public void testInertCart() throws Exception {
//		Cart cart = new Cart();
//		cart.setCart_id("1");
//		cart.setUser_id("1");
//		System.out.println(cartMapper.insertCart(cart));
	}

	@Test
	public void testSelectCartByUser_id() throws Exception {
		System.out.println(cartMapper.selectCartByUser_id("1"));
	}

}
