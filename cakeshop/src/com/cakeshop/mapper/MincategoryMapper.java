package com.cakeshop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Mincategory;

public interface MincategoryMapper {
	//根据大分类查询小分类
	public List<Mincategory> selectMincategory(String max_id) throws Exception;
}