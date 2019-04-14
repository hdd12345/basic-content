package com.shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.entity.Goods_img;

@Repository("goods_imgMapper")
public interface Goods_imgMapper {
	//添加图片
	public int insertGoods_img(Goods_img goods_img) throws Exception;
	//根据商品id查询图片
	public List<Goods_img> selectGoods_imgByGoods_id(int goods_id) throws Exception;
	//删除图片
	public int deleteGoods_img(int goods_img_id) throws Exception;
}
