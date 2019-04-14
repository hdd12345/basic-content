package com.shop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.entity.Shop;
import com.shop.service.ShopService;

@RequestMapping(value="/shop")
@Controller
public class ShopController {
	@Resource(name="shopServiceImpl")
	private ShopService shopService;
	
	/**
	 * 添加店铺
	 * @param shop
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertShop",method=RequestMethod.POST)
	@ResponseBody
	public int insertShop(@RequestBody Shop shop) throws Exception{
		return shopService.insertShop(shop);
	}
	
	/**
	 * 修改店铺信息
	 * @param shop
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateShop",method=RequestMethod.POST)
	@ResponseBody
	public int updateShop(@RequestBody Shop shop) throws Exception{
		return shopService.updateShop(shop);
	}
}
