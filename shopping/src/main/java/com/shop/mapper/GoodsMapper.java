package com.shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.entity.Goods;

@Repository("goodsMapper")
public interface GoodsMapper {
	//添加商品
	public int insertGoods(Goods goods) throws Exception;
	//修改商品信息
	public int updateGoods(Goods goods) throws Exception;
	//根据店铺id查询商品
	public List<Goods> selectGoodsByShop_id(int shop_id) throws Exception;
	//商品模糊查询并排序（1、全匹配，2、头匹配，3、尾匹配，4、中间匹配）
	public List<Goods> selectGoodsAndSort(String key_word) throws Exception;
	//根据商品id查询商品
	public Goods selectGoodsByGoods_id(int goods_id) throws Exception;
	//根据分类查询商品
	public List<Goods> selectGoodsByGoods_type(String goods_type) throws Exception;
}
