package com.shop.test.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Goods;
import com.shop.mapper.GoodsMapper;

public class GoodsMapperTest {
	private ApplicationContext ac;
	private GoodsMapper goodsMapper;
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		goodsMapper = (GoodsMapper)ac.getBean("goodsMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertGoods() throws Exception {
//		Goods goods = new Goods();
//		goods.setGoods_name("哇哈哈");
//		goods.setGoods_num("4324895");
//		goods.setGoods_type("食品");
//		goods.setNumber(100);
//		goods.setPrice(3);
//		goods.setShop_id(2);
//		goods.setDetail("超好喝的！");
//		System.out.println(goodsMapper.insertGoods(goods));
	}

	@Test
	public void testUpdateGoods() throws Exception {
		Goods goods = new Goods();
		goods.setGoods_name("娃哈哈");
		goods.setGoods_id(7);
		goods.setShop_id(2);
		goods.setDetail("超好喝的。。");
		System.out.println(goodsMapper.updateGoods(goods));
	}

	@Test
	public void testSelectGoodsByShop_id() throws Exception {
		List<Goods> list = goodsMapper.selectGoodsByShop_id(2);
		for(Goods goods:list) {
			System.out.println(goods);
		}
	}

	@Test
	public void testSelectGoodsAndSort() throws Exception {
		List<Goods> list = goodsMapper.selectGoodsAndSort("小猪");
		for(Goods goods:list) {
			System.out.println(goods);
		}
	}
	
	@Test
	public void testSelectGoodsByGoods_id() throws Exception{
		System.out.println(goodsMapper.selectGoodsByGoods_id(5));
	}
	
	@Test
	public void testSelectGoodsByGoods_type() throws Exception{
		List<Goods> list = goodsMapper.selectGoodsByGoods_type("食品");
		for(Goods goods:list) {
			System.out.println(goods);
		}
	}

}
