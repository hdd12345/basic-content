package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Goods;
import com.shop.entity.Goods_img;
import com.shop.mapper.GoodsMapper;
import com.shop.mapper.Goods_imgMapper;
import com.shop.service.GoodsService;

@Service("goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService{
	@Resource(name="goodsMapper")
	private GoodsMapper goodsMapper;
	@Resource(name="goods_imgMapper")
	private Goods_imgMapper goods_imgMapper;
	
	/**
	 * 模糊查询商品并排序
	 */
	@Override
	public List<Goods> selectGoodsAndSort(String key_word) throws Exception {
		return goodsMapper.selectGoodsAndSort(key_word);
	}
	
	/**
	 * 添加商品及商品图片
	 */
	@Override
	public int insertGoods(Goods goods) throws Exception {
		int count = 0;
		count = goodsMapper.insertGoods(goods);
		if(goods.getList_goods_img()!=null) {
			for(Goods_img goods_img:goods.getList_goods_img()) {
				goods_img.setGoods_id(goods.getGoods_id());
				count+=goods_imgMapper.insertGoods_img(goods_img);
			}
		}
		return count;
	}
	
	/**
	 * 修改商品信息
	 */
	@Override
	public int updateGoods(Goods goods) throws Exception {
		return goodsMapper.updateGoods(goods);
	}
	
	/**
	 * 根据店铺id查询商品
	 */
	@Override
	public List<Goods> selectGoodsByShop_id(int shop_id) throws Exception {
		return goodsMapper.selectGoodsByShop_id(shop_id);
	}
	
	/**
	 * 添加商品
	 */
	@Override
	public int insertGoods_img(Goods_img goods_img) throws Exception {
		return goods_imgMapper.insertGoods_img(goods_img);
	}
	
	/**
	 * 删除商品图片
	 */
	@Override
	public int deleteGoods_img(int goods_img_id) throws Exception {
		return goods_imgMapper.deleteGoods_img(goods_img_id);
	}
	
	/**
	 * 根据分类查询商品
	 */
	@Override
	public List<Goods> selectGoodsByGoods_type(String goods_type) throws Exception {
		return goodsMapper.selectGoodsByGoods_type(goods_type);
	}
	
}
