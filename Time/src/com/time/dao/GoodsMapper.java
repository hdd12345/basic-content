package com.time.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.time.entity.Goods;

@Repository("goodsDao")
public interface GoodsMapper {
	// 根据id数组批量删除
	int deleteByPrimaryKeyArray(@Param("array") Long[] gId);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Long gId);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);

	// 不插入id，剩余的根据字段是否为空，插入list
	int insertListSelective(@Param("list") List<Goods> gList);

	// 根据条件查询
	List<Goods> selectGoods(@Param("roleType") String roleType, @Param("goodsType") String goodsType,
			@Param("desc") String desc, @Param("goodsNum") String goodsNum, @Param("pageNum") String pageNum,
			@Param("pageTotal") String pageTotal);
	
	int changeGoods(@Param("gId")Long gId);
}