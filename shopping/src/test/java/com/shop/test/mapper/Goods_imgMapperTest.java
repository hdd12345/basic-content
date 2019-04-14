package com.shop.test.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.entity.Goods_img;
import com.shop.mapper.Goods_imgMapper;

public class Goods_imgMapperTest {
	private ApplicationContext ac;
	private Goods_imgMapper goods_imgMapper;
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		goods_imgMapper = (Goods_imgMapper)ac.getBean("goods_imgMapper");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertGoods_img() throws Exception {
//		Goods_img goods_img = new Goods_img();
//		goods_img.setGoods_img_name("timor1.jpg");
//		goods_img.setGoods_id(7);
//		System.out.println(goods_imgMapper.insertGoods_img(goods_img));
	}

	@Test
	public void testSelectGoods_imgByGoods_id() throws Exception {
		List<Goods_img> list = goods_imgMapper.selectGoods_imgByGoods_id(7);
		for(Goods_img goods_img:list) {
			System.out.println(goods_img);
		}
	}

	@Test
	public void testDeleteGoods_img() throws Exception {
//		System.out.println(goods_imgMapper.deleteGoods_img(2));
	}

}
