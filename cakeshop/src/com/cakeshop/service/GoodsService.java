package com.cakeshop.service;

import java.util.List;

import com.cakeshop.entity.Goods;
import com.cakeshop.entity.Maxcategory;
import com.cakeshop.entity.Mincategory;
import com.cakeshop.entity.PageBean;

public interface GoodsService {
	// 查询所有商品
	public List<Goods> selectAllGoods() throws Exception;

	// 商品模糊查询
	public List<Goods> selectVagueGoods(String key_word) throws Exception;

	// 查询单个商品的具体信息
	public Goods selectGoods(String goods_id) throws Exception;

	// 根据类别ID,查找的页码检索相应的商品列表
	public PageBean<Goods> findGoodsListBymin_id(String min_id, int currentPage, int currentCount) throws Exception;

	// 查询大菜单中所有类别
	public List<Maxcategory> selectMaxcategory() throws Exception;

	//根据大分类查询小分类
	public List<Mincategory> selectMincategory(String max_id) throws Exception;
	//查询所有分类
	public List<Maxcategory> selectCategory() throws Exception;
	
	//查询最新8条商品
	
		public List<Goods> selectNewGoods()throws Exception;
}
