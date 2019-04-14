package com.shop.test.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Cart_items;
import com.shop.mapper.Cart_itemsMapper;

public class Cart_itemsMapperTest {
	private ApplicationContext applicationContext;
	private Cart_itemsMapper cart_itemsMapper;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		cart_itemsMapper = (Cart_itemsMapper)applicationContext.getBean("cart_itemsMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertCart_items() throws Exception {
//		Cart_items cart_items = new Cart_items();
//		cart_items.setCart_id(1);
//		cart_items.setGoods_id(4);
//		cart_items.setQuantity(1);
//		cart_items.setTotal_price(56);
//		System.out.println(cart_itemsMapper.insertCart_items(cart_items));
	}

	@Test
	public void testDeleteCart_items() throws Exception {
//		System.out.println(cart_itemsMapper.deleteCart_items(2));
	}

	@Test
	public void testUpdateCart_items() throws Exception {
		Cart_items cart_items = new Cart_items();
		cart_items.setCart_id(1);
		cart_items.setGoods_id(4);
		cart_items.setQuantity(3);
		cart_items.setTotal_price(56);
		cart_items.setCart_items_id(1);		
		System.out.println(cart_itemsMapper.updateCart_items(cart_items));
	}

	@Test
	public void testSelectAllCart_items() throws Exception {
		List<Cart_items> list = cart_itemsMapper.selectAllCart_items(1);
		for(Cart_items cart_items:list) {
			System.out.println(cart_items);
		}
	}
	
	@Test
	public void testSelectCart_items() throws Exception{
		List<Cart_items> list = cart_itemsMapper.selectCart_items(new int[] {1,3});
		for(Cart_items cart_items:list) {
			System.out.println(cart_items);
		}
	}
	
	@Test
	public void testDeleteManyCart_items() throws Exception{
//		System.out.println(cart_itemsMapper.deleteManyCart_items(new int[] {4,5}));
	}

}
