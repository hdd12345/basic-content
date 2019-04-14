package com.time.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.time.entity.GoodsType;

@Repository("goodsTypeDao")
public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer gType);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer gType);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    List<GoodsType> selectAll();
}