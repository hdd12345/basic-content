package com.cakeshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Goods;

public interface GoodsMapper {
	// 查询所有商品
	public List<Goods> selectAllGoods() throws Exception;

	// 商品模糊查询
	public List<Goods> selectVagueGoods(String key_word) throws Exception;

	// 查询单个商品的具体信息
	public Goods selectGoods(String goods_id) throws Exception;

	// 查询商品总数
	public int selectAllGoodsCount(String min_id) throws Exception;

	// 根据类别ID,查找的页码检索相应的商品列表
	public List<Goods> selectGoodsPage(@Param(value = "min_id") String min_id, @Param(value = "start") int start,
			@Param(value = "count") int count) throws Exception;
	//查询最新8条商品
	public List<Goods> selectNewGoods()throws Exception;
}