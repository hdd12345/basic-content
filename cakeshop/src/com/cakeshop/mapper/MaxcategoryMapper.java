package com.cakeshop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Maxcategory;

public interface MaxcategoryMapper {
	// ��ѯ��˵����������
	public List<Maxcategory> selectMaxcategory() throws Exception;
	//��ѯ���з��ࣨ������ѯ������������С������Ϣ��
	public List<Maxcategory> selectCategory() throws Exception;
}