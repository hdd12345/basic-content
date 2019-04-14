package com.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Shop;
import com.shop.mapper.ShopMapper;
import com.shop.service.ShopService;
@Service("shopServiceImpl")
public class ShopServiceImpl implements ShopService{
	@Resource(name="shopMapper")
	private ShopMapper shopMapper;
	
	@Override
	public int insertShop(Shop shop) throws Exception {
		return shopMapper.insertShop(shop);
	}

	@Override
	public int updateShop(Shop shop) throws Exception {
		return shopMapper.updateShop(shop);
	}

}
