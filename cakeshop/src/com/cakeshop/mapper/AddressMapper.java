package com.cakeshop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.entity.Address;

public interface AddressMapper {
	// 查询一个用户的地址
	public List<Address> selectAddress(String userId) throws Exception;

	// 删除用户地址
	public int deleteAddess(String addressId) throws Exception;

	// 增加用户地址
	public int insertAddess(Address address) throws Exception;

	// 修改用户地址
	public int updateAddress(Address address) throws Exception;
	
	//查询所有省份
	public List<String> selectProvince()throws Exception;
	
	//查询省份对应的市区
	
	public List<String> selectCtiy(String area_parent_id)throws Exception;

}