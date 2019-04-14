package com.time.service;

import java.util.List;

import com.time.entity.Goods;
import com.time.entity.GoodsType;

public interface GoodsService {
	// 添加新的商品信息，从表格导入
	public int addManyNewGoods(String goodsExcelURL);

	// 添加新的商品信息，直接在线录入
	public int addNewGoods(Goods goods);

	// 修改旧商品的信息
	public int changeGoods(Long gId);

	// 删除商品
	public int removeGoods(Long gId[]);

	// 查询商品信息
	public List<Goods> showGoods(Integer roleType, Integer goodsType, String desc, String goodsNum, Integer pageNum,
			Integer pageTotal);
	
	public List<GoodsType> getAllType();

	public int modifyGoodsInfo(Goods goods);

}
