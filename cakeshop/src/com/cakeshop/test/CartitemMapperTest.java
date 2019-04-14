package com.cakeshop.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.Cartitem;
import com.cakeshop.entity.CartitemInfo;
import com.cakeshop.mapper.CartitemMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class CartitemMapperTest {
	
	@Resource(name="cartitemMapper")
	CartitemMapper cartitemMapper;
	
	@Test
	public void testSelectByCart_id() throws Exception {
		List<CartitemInfo> list = cartitemMapper.selectByCart_id("1");
		for(CartitemInfo c:list){
			System.out.println(c);
		}
	}

	@Test
	public void testDeleteCartitems() throws Exception {
		String [] cartitem_ids = new String[]{"3","4"};
		System.out.println(cartitemMapper.deleteCartitems(cartitem_ids));
	}

	@Test
	public void testInsertCartitem() throws Exception {
//		Cartitem c = new Cartitem();
//		c.setCart_id("1");
//		c.setGoods_id("2");
//		c.setQuantity(1);
//		c.setCartitem_id("2");
//		System.out.println(cartitemMapper.insertCartitem(c));
	}

	@Test
	public void testUpdateCartitem() throws Exception {
//		Cartitem c = new Cartitem();
//		c.setCart_id("1");
//		c.setGoods_id("2");
//		c.setQuantity(2);
//		c.setCartitem_id("2");
//		System.out.println(cartitemMapper.updateCartitem(c));
	}

}
