package com.shop.test.mapper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Orders_detail;
import com.shop.mapper.Orders_detailMapper;

public class Orders_detailMapperTest {
	private ApplicationContext applicationContext;
	private Orders_detailMapper orders_detailMapper;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		orders_detailMapper = (Orders_detailMapper)applicationContext.getBean("orders_detailMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOrders_detail() throws Exception {
		Orders_detail orders_detail = new Orders_detail();
		orders_detail.setOrders_id(6);
		orders_detail.setGoods_id(5);
		orders_detail.setQuantity(1);
		orders_detail.setTotal_price(1999);
		System.out.println(orders_detailMapper.insertOrders_detail(orders_detail));
		System.out.println(orders_detail.getOrders_detail_id());
	}

}
