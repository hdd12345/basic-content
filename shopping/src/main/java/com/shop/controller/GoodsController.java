package com.shop.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.Goods;
import com.shop.entity.Goods_img;
import com.shop.service.GoodsService;

import net.sf.json.JSONObject;

@RequestMapping(value="/goods")
@Controller
public class GoodsController {
	@Resource(name="goodsServiceImpl")
	private GoodsService goodsService;
	
	/**
	 * 图片上传，返回上传完成后的图片名字
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/upload_img",method=RequestMethod.POST,produces= {"application/json;charset=utf-8"})	
	public @ResponseBody JSONObject upload_img(@RequestParam MultipartFile file) throws Exception{
		//存储图片物理路径
		String pic_path = "E:\\project_picture";
		//图片原名
		String originalFilename = file.getOriginalFilename();
		//新的图片名称
		String newName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
		//新图片
		File newFile = new File(pic_path+"\\"+newName);
		file.transferTo(newFile);
		JSONObject json = JSONObject.fromObject("{newName:"+newName+"}");
		return json;
	}
	
	
	/**
	 * 添加商品,主键返回
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertGoods",method=RequestMethod.POST)
	@ResponseBody
	public int insertGoods(@RequestBody Goods goods) throws Exception{
		return goodsService.insertGoods(goods);
	}
	
	/**
	 * 修改商品
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateGoods",method=RequestMethod.POST)
	@ResponseBody
	public int updateGoods(@RequestBody Goods goods) throws Exception{
		return goodsService.updateGoods(goods);
	}
	
	/**
	 * 添加商品图片
	 * @param goods_img
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="insertGoods_img",method=RequestMethod.POST)
	@ResponseBody
	public int insertGoods_img(@RequestBody Goods_img goods_img) throws Exception {
		return goodsService.insertGoods_img(goods_img);
	}	
	
	/**
	 * 删除商品图片
	 * @param goods_img_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="deleteGoods_img",method=RequestMethod.POST)
	@ResponseBody
	public int deleteGoods_img(@RequestParam int goods_img_id) throws Exception{
		return goodsService.deleteGoods_img(goods_img_id);
	}
	
	/**
	 * 商品模糊查询
	 * @param key_word
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectGoodsAndSort",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Goods> selectGoodsAndSort(@RequestParam String key_word) throws Exception{
		return goodsService.selectGoodsAndSort(key_word);
	}
	
	/**
	 * 查询店铺商品
	 * @param shop_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectGoodsByShop_id",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Goods> selectGoodsByShop_id(@RequestParam int shop_id) throws Exception{
		return goodsService.selectGoodsByShop_id(shop_id);
	}
	
	/**
	 * 商品分类查询
	 * @param goods_type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectGoodsByGoods_type",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<Goods> selectGoodsByGoods_type(String goods_type) throws Exception{
		return goodsService.selectGoodsByGoods_type(goods_type);
	}
	
}
