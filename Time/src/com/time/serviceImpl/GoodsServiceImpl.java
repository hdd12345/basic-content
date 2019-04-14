package com.time.serviceImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.time.dao.GoodsMapper;
import com.time.dao.GoodsTypeMapper;
import com.time.entity.Goods;
import com.time.entity.GoodsType;
import com.time.service.GoodsService;
import com.time.util.ExcelReadUtil;

@Service("goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {
	@Resource(name = "goodsDao")
	private GoodsMapper goodsDao;
	@Resource(name = "goodsTypeDao")
	private GoodsTypeMapper goodsTypeDao;

	/**
	 * 添加新的商品（支持批量添加,从Excel表格导入数据） 适用于依次添加大量数据)
	 */
	@Override
	public int addManyNewGoods(String goodsExcelURL) {
		// 先判断文件类型是否合法，是否是.xls或.xlsx文件
		if (!ExcelReadUtil.validateExcel(goodsExcelURL)) {
			System.out.println("文件格式不对");
			return 0;
		}
		HashMap<Integer, HashMap<Integer, Object>> goodsExcelContent = null;
		ExcelReadUtil goodsExcelReader = new ExcelReadUtil(goodsExcelURL);
		try {
			goodsExcelContent = goodsExcelReader.readExcelContent();
		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 没有商品信息就结束插入
		if (goodsExcelContent.size() < 1)
			return 0;
		// 从Map中读数据
		List<Goods> gList = new ArrayList<Goods>();
		for (int i = 1; i <= goodsExcelContent.size(); i++) {
			HashMap<Integer, Object> hashMap = goodsExcelContent.get(i);
			String goodsNum = (String) hashMap.get(1);
			String goodsName = (String) hashMap.get(2);
			int consume = Integer.valueOf((String) hashMap.get(3));
			int count = Integer.valueOf((String) hashMap.get(4));
			String goodsLog = (String) hashMap.get(5);
			int goodsType = Integer.valueOf((String) hashMap.get(6));
			gList.add(new Goods(goodsNum, goodsName, consume, count, goodsLog, goodsType));
		}
		return goodsDao.insertListSelective(gList);
	}

	/**
	 * 添加新的商品,直接在线录入,适用于少量数据添加
	 */
	@Override
	public int addNewGoods(Goods goods) {
		return goodsDao.insertSelective(goods);
	}

	/**
	 * 修改旧商品的信息
	 */
	@Override
	public int changeGoods(Long gId) {
		return goodsDao.changeGoods(gId);
	}

	/**
	 * 删除商品（支持批量删除，接收商品id数组）
	 */
	@Override
	public int removeGoods(Long[] gId) {
		return goodsDao.deleteByPrimaryKeyArray(gId);
	}

	/**
	 * 查询商品信息（管理员查看和用户查看是不同的，商品库存为0时，用户就看不到该商品了，管理员可以）
	 * 支持按名称的模糊查询和类型分类查询,按编号精准查询商品（查询编号完全匹配和模糊匹配的）
	 */
	@Override
	public List<Goods> showGoods(Integer roleType, Integer goodsType, String desc, String goodsNum, Integer pageNum,
			Integer pageTotal) {
		// roleType在前面设置了不能为空，不用处理
		// 但如果goodsType==0，直接转换为String传过去，mapper会报错，因为它会被转换成"null"字符串,并不是空
		String typeStr = null;
		String pageNumStr = null;
		String pageTotalStr = null;
		System.out.println(String.valueOf(goodsType));
		if (goodsType != null)
			typeStr = String.valueOf(goodsType);
		if (pageNum != null && pageTotal != null) {
			pageNumStr = String.valueOf(pageTotal * (pageNum - 1));
			pageTotalStr = String.valueOf(pageTotal);
		}
		return goodsDao.selectGoods(String.valueOf(roleType), typeStr, desc, goodsNum, pageNumStr, pageTotalStr);
	}

	/**
	 * 查询所有商品类型
	 */
	@Override
	public List<GoodsType> getAllType() {
		return goodsTypeDao.selectAll();
	}

	@Override
	public int modifyGoodsInfo(Goods goods) {
		return goodsDao.updateByPrimaryKeySelective(goods);
	}
}
