package com.cakeshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.entity.Goods;
import com.cakeshop.entity.Maxcategory;
import com.cakeshop.entity.Mincategory;
import com.cakeshop.entity.PageBean;
import com.cakeshop.service.GoodsService;



@RequestMapping("/goods")
@Controller
public class GoodsController {
	@Resource(name = "goodsServiceImpl")
	private GoodsService goodsService;

	/**
	 * 查询所有商品信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAllGoods", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Goods> selectAllGoods() throws Exception {
		List<Goods> list = goodsService.selectAllGoods();

		return list;

	}

	/**
	 * 模糊查询商品信息
	 * 
	 * @param key_word
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectVagueGoods", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Goods> selectVagueGoods(@RequestParam String key_word) throws Exception {
		List<Goods> list = goodsService.selectVagueGoods(key_word);

		return list;

	}

	/**
	 * 查看单个商品的具体信息
	 * 
	 * @param goods_id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectGoods", method = { RequestMethod.POST, RequestMethod.GET })
	public Goods selectGoods(@RequestParam String goods_id, HttpServletRequest request) throws Exception {
		Goods goods = goodsService.selectGoods(goods_id);
		List<Goods> goodsList = (ArrayList<Goods>)request.getSession().getAttribute("goodsList");
		if(goodsList!=null){
			goodsList.add(goods);//存入浏览记录
		}
		return goods;
	}

	/**
	 * 查询大菜单中所有类别
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/maxcategory", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Maxcategory> selectMaxcategory() throws Exception {
		List<Maxcategory> list = goodsService.selectMaxcategory();
		return list;
	}

	/**
	 * 查询小菜单中所有类别
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/mincategory", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Mincategory> selectMincategory(@RequestParam String max_id) throws Exception {
		List<Mincategory> list = goodsService.selectMincategory(max_id);

		return list;

	}

	/**
	 * 商品分页操作
	 * 
	 * @param min_id
	 * @param currentPage
	 * @param currentCount
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getGoodsByMin_id", method = { RequestMethod.POST, RequestMethod.GET })
	public PageBean<Goods> findGoodsListBymin_id(@RequestParam String min_id,
			@RequestParam int currentPage,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int currentCount = 8;
		PageBean<Goods> pageBean = goodsService.findGoodsListBymin_id(min_id, currentPage, currentCount);
		return pageBean;
	}
	
	/**
	 * 查询最新8条商品
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectNewGoods", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Goods> selectNewGoods(HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<Goods> goodsList = (ArrayList<Goods>)request.getSession().getAttribute("goodsList");
		if(goodsList==null){
			goodsList = new ArrayList<>();
			request.getSession().setAttribute("goodsList",goodsList);//goodsList用于存储浏览记录
		}
		return goodsService.selectNewGoods();
	}

}
