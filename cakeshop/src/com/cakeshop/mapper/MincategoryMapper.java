package com.cakeshop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Mincategory;

public interface MincategoryMapper {
	//���ݴ�����ѯС����
	public List<Mincategory> selectMincategory(String max_id) throws Exception;
}