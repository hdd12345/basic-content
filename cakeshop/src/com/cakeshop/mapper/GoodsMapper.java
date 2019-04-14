package com.cakeshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Goods;

public interface GoodsMapper {
	// ��ѯ������Ʒ
	public List<Goods> selectAllGoods() throws Exception;

	// ��Ʒģ����ѯ
	public List<Goods> selectVagueGoods(String key_word) throws Exception;

	// ��ѯ������Ʒ�ľ�����Ϣ
	public Goods selectGoods(String goods_id) throws Exception;

	// ��ѯ��Ʒ����
	public int selectAllGoodsCount(String min_id) throws Exception;

	// �������ID,���ҵ�ҳ�������Ӧ����Ʒ�б�
	public List<Goods> selectGoodsPage(@Param(value = "min_id") String min_id, @Param(value = "start") int start,
			@Param(value = "count") int count) throws Exception;
	//��ѯ����8����Ʒ
	public List<Goods> selectNewGoods()throws Exception;
}