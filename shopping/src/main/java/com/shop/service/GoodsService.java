package com.shop.service;

import java.util.List;

import com.shop.entity.Goods;
import com.shop.entity.Goods_img;

public interface GoodsService {
	//商品模糊查询
	public List<Goods> selectGoodsAndSort(String key_word) throws Exception;	
	//添加商品
	public int insertGoods(Goods goods) throws Exception;
	//修改商品信息
	public int updateGoods(Goods goods) throws Exception;
	//根据店铺id查询商品
	public List<Goods> selectGoodsByShop_id(int shop_id) throws Exception;
	//添加商品图片
	public int insertGoods_img(Goods_img goods_img) throws Exception;
	//删除商品图片
	public int deleteGoods_img(int goods_img_id) throws Exception;
	//根据分类查询商品
	public List<Goods> selectGoodsByGoods_type(String goods_type) throws Exception;
}
