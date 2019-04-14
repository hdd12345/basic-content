package com.cakeshop.service;

import java.util.List;

import com.cakeshop.entity.Goods;
import com.cakeshop.entity.Maxcategory;
import com.cakeshop.entity.Mincategory;
import com.cakeshop.entity.PageBean;

public interface GoodsService {
	// ��ѯ������Ʒ
	public List<Goods> selectAllGoods() throws Exception;

	// ��Ʒģ����ѯ
	public List<Goods> selectVagueGoods(String key_word) throws Exception;

	// ��ѯ������Ʒ�ľ�����Ϣ
	public Goods selectGoods(String goods_id) throws Exception;

	// �������ID,���ҵ�ҳ�������Ӧ����Ʒ�б�
	public PageBean<Goods> findGoodsListBymin_id(String min_id, int currentPage, int currentCount) throws Exception;

	// ��ѯ��˵����������
	public List<Maxcategory> selectMaxcategory() throws Exception;

	//���ݴ�����ѯС����
	public List<Mincategory> selectMincategory(String max_id) throws Exception;
	//��ѯ���з���
	public List<Maxcategory> selectCategory() throws Exception;
	
	//��ѯ����8����Ʒ
	
		public List<Goods> selectNewGoods()throws Exception;
}
