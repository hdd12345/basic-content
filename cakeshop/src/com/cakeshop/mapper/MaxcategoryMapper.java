package com.cakeshop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Maxcategory;

public interface MaxcategoryMapper {
	// 查询大菜单中所有类别
	public List<Maxcategory> selectMaxcategory() throws Exception;
	//查询所有分类（关联查询，包含大分类和小分类信息）
	public List<Maxcategory> selectCategory() throws Exception;
}