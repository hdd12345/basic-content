package com.cakeshop.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.Ordersitem;
import com.cakeshop.mapper.OrdersitemMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class OrdersitemMapperTest {
	
	@Resource(name="ordersitemMapper")
	OrdersitemMapper ordersitemMapper;
	
	@Test
	public void testInsertOrdersitem() throws Exception {
//		Ordersitem oi = new Ordersitem();
//		oi.setOrdersitem_id("3");
//		oi.setOrders_id("2");
//		oi.setGoods_id("1");
//		oi.setQuantity(1);
//		oi.setTotal_price(188.0);
//		System.out.println(ordersitemMapper.insertOrdersitem(oi));
	}

	@Test
	public void testSelectById() throws Exception {
		System.out.println(ordersitemMapper.selectById("3"));
	}

	@Test
	public void testDeleteOrdersitem() {
		fail("Not yet implemented");
	}

}
