package com.cakeshop.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.cakeshop.entity.Goods;
import com.cakeshop.entity.Maxcategory;
import com.cakeshop.entity.Mincategory;
import com.cakeshop.entity.PageBean;
import com.cakeshop.mapper.AddressMapper;
import com.cakeshop.mapper.GoodsMapper;
import com.cakeshop.mapper.MaxcategoryMapper;
import com.cakeshop.mapper.MincategoryMapper;
import com.cakeshop.service.GoodsService;
import com.cakeshop.util.CommonUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service("goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {
	@Resource(name = "goodsMapper")
	private GoodsMapper goodsMapper;
	@Resource(name = "maxcategoryMapper")
	private MaxcategoryMapper maxcategoryMapper;
	@Resource(name = "mincategoryMapper")
	private MincategoryMapper mincategoryMapper;
	@Resource(name="jedisPool")
	private JedisPool pool;

	/**
	 * ��ѯ������Ʒ
	 */
	@Override
	public List<Goods> selectAllGoods() throws Exception {
		List<Goods> list = goodsMapper.selectAllGoods();
		return list;
	}

	/**
	 * ģ����ѯ��Ʒ
	 */
	@Override
	public List<Goods> selectVagueGoods(String key_word) throws Exception {
		List<Goods> list = goodsMapper.selectVagueGoods(key_word);
		return list;
	}

	/**
	 * ������Ʒid����ѯ��Ʒ������Ϣ
	 * ��ȥredis�����в�ѯ���������ڣ�ȥmysql�в�ѯ������redis��
	 */
	@Override
	public Goods selectGoods(String goods_id) throws Exception {
		Jedis jedis = pool.getResource();
		Goods goods = new Goods();
		if(jedis.exists(goods_id)) {
			Map<String,String> map = jedis.hgetAll(goods_id);
			CommonUtil.mapToObject(map,goods);
			//BeanUtils.populate(goods,map);//�޷������������͵�ת��
		}else {
			goods = goodsMapper.selectGoods(goods_id);
			//javaBeanתMap
			Map<String,String> map = BeanUtils.describe(goods);
			//����redis��
			jedis.hmset(goods.getGoods_id(),map);
		}
		return goods;
	}

	/**
	 * ��ҳ����
	 */
	@Override
	public PageBean<Goods> findGoodsListBymin_id(String min_id, int currentPage, int currentCount) throws Exception {
		PageBean<Goods> pageBean = new PageBean<>();
		int totalCount = goodsMapper.selectAllGoodsCount(min_id);
		int totalPage = totalCount % currentCount > 0 ? (totalCount / currentCount) + 1 : totalCount / currentCount;
		int start = (currentPage - 1) * currentCount;
		if (currentPage == totalPage) {
			currentCount = totalCount % currentCount;
		}
		List<Goods> list = goodsMapper.selectGoodsPage(min_id, start, currentCount);
		pageBean.setList(list);
		pageBean.setCurrentCount(currentCount);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	/**
	 * ��ѯ��˵������е����
	 */
	@Override
	public List<Maxcategory> selectMaxcategory() throws Exception {
		List<Maxcategory> list = maxcategoryMapper.selectMaxcategory();
		return list;
	}

	/**
	 * ��ѯС�˵����������
	 */
	@Override
	public List<Mincategory> selectMincategory(String max_id) throws Exception {
		List<Mincategory> list = mincategoryMapper.selectMincategory(max_id);
		return list;

	}
	
	/**
	 * ��ѯ���з��ࣨ��������༰С������Ϣ��
	 */
	@Override
	public List<Maxcategory> selectCategory() throws Exception {
		return maxcategoryMapper.selectCategory();
	}
	
	@Override
	/**
	 * ��ѯ����8����Ʒ
	 */
	public List<Goods> selectNewGoods() throws Exception {
		
		return goodsMapper.selectNewGoods();
	}
}
