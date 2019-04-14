package com.shop.test.mapper;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Shop;
import com.shop.mapper.ShopMapper;

public class ShopMapperTest {
	private ApplicationContext ac;
	private ShopMapper shopMapper;
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		shopMapper = (ShopMapper)ac.getBean("shopMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertShop() throws Exception {
		Shop shop = new Shop();
		shop.setBuild_time(new Date(new java.util.Date().getTime()));
		shop.setShop_name("hahaha");
		shop.setUser_id(3);
		System.out.println(shopMapper.insertShop(shop));
	}

	@Test
	public void testUpdateShop() throws Exception {
		Shop shop = new Shop();
		shop.setBuild_time(new Date(new java.util.Date().getTime()));
		shop.setShop_id(2);
		shop.setShop_name("123");
		shop.setUser_id(2);
		System.out.println(shopMapper.updateShop(shop));
		
		
	}

}
