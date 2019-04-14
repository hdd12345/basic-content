package com.shop.service;

import com.shop.entity.Shop;

public interface ShopService {
	//添加店铺
	public int insertShop(Shop shop) throws Exception;
	//修改店铺信息
	public int updateShop(Shop shop) throws Exception;
}
