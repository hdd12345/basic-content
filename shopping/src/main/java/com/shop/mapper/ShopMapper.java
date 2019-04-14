package com.shop.mapper;

import org.springframework.stereotype.Repository;

import com.shop.entity.Shop;

@Repository("shopMapper")
public interface ShopMapper {
	//添加店铺
	public int insertShop(Shop shop) throws Exception;
	//修改店铺信息
	public int updateShop(Shop shop) throws Exception;
}
