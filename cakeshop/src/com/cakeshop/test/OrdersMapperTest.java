package com.cakeshop.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.Orders;
import com.cakeshop.mapper.OrdersMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class OrdersMapperTest {
	
	@Resource(name="ordersMapper")
	OrdersMapper ordersMapper;
	
//	@Test
//	public void testSelectOrdersByUser_id() throws Exception {
//		List<Orders> list = ordersMapper.selectOrdersByUser_id("1");
//		for(Orders o:list){
//			System.out.println(o);
//		}
//	}

	@Test
	public void testSelectOrdersByOrders_id() throws Exception {
		System.out.println(ordersMapper.selectOrdersByOrders_id("1"));
	}

	@Test
	public void testInsertOrders() throws Exception {
		Orders o = new Orders();
		o.setOrders_id("2");
		o.setOrders_num("201809164351");
		o.setOrders_time(new Date());
		o.setOrders_total_price(188.0);
		o.setAddress_id("1");
		o.setUser_id("1");
		System.out.println(ordersMapper.insertOrders(o));
	}

	@Test
	public void testDeleteOrders() {
		//´ý²â
	}
	
	@Test
	public void testSelectOrdersCount() throws Exception{
		System.out.println(ordersMapper.selectOrdersCount("20180915"));
	}

}
