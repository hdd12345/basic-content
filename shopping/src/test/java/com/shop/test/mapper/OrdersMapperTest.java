package com.shop.test.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Orders;
import com.shop.mapper.OrdersMapper;

public class OrdersMapperTest {
	private ApplicationContext applicationContext;
	private OrdersMapper ordersMapper;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		ordersMapper = (OrdersMapper)applicationContext.getBean("ordersMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOrders() throws Exception {
//		Orders orders = new Orders();
//		orders.setOrders_num("2018072466613");
//		orders.setOrders_total_price(98);;
//		orders.setOrders_time(new Date());
//		orders.setUser_id(3);
//		orders.setShop_id(2);
//		orders.setAddress_id(1);
//		System.out.println(ordersMapper.insertOrders(orders));
	}

	@Test
	public void testSelectOrdersByUser_id() throws Exception {
		List<Orders> list = ordersMapper.selectOrdersByUser_id(3);
		for(Orders orders:list) {
			System.out.println(orders);
		}
	}

	@Test
	public void testSelectOrdersByShop_id() throws Exception{
		List<Orders> list = ordersMapper.selectOrdersByShop_id(2);
		for(Orders orders:list) {
			System.out.println(orders);
		}
	}
	
	@Test
	public void testselectOrdersByState() throws Exception{
		List<Orders> list = ordersMapper.selectOrdersByState(2,"待发货");
		for(Orders orders:list) {
			System.out.println(orders);
		}
	}

	@Test
	public void testUpdateOrders_state() throws Exception {
		System.out.println(ordersMapper.updateOrders_state("已发货",1));
	}

	@Test
	public void testSelectOrders() throws Exception {
		List<Orders> list = ordersMapper.selectOrders("小猪",3);
		for(Orders orders:list) {
			System.out.println(orders);
		}
	}
	
	@Test
	public void testSelectOrdersByDate() throws Exception{
		List<Orders> list = ordersMapper.selectOrdersByDate("20180724");
		for(Orders orders:list) {
			System.out.println(orders);
		}
	}

}
