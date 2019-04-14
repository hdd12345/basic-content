package com.cakeshop.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakeshop.entity.Goods;
import com.cakeshop.mapper.GoodsMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class GoodsMapperTest {
	@Resource(name = "goodsMapper")
	public GoodsMapper goodsMapper;

	@Test
	public void testSelectAllGoods() throws Exception {
		/*
		 * Goods goods = new Goods();
		 * System.out.println(goodsMapper.selectAllGoods());
		 */

	}

	@Test
	public void testSelectVagueGoods() throws Exception {
		/*
		 * Goods goods = new Goods();
		 * System.out.println(goodsMapper.selectVagueGoods("d"));
		 */
	}

	@Test
	public void testSelectGoods() throws Exception {
		/*
		 * Goods goods = new Goods();
		 * System.out.println(goodsMapper.selectGoods("1"));
		 */
	}

	@Test
	public void testselectAllGoodsCount() throws Exception {
		/*
		 * Goods goods = new Goods();
		 * System.out.println(goodsMapper.selectAllGoodsCount("1"));
		 */
	}

	@Test
	public void testselectGoodsCount() throws Exception {
		/*
		 * Goods goods = new Goods();
		 * System.out.println(goodsMapper.selectGoodsCount("1", 0, 1));
		 */
	}
}
