package com.shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.entity.Address;
@Repository("addressMapper")
public interface AddressMapper {
	//添加地址
	public int insertAddress(Address address) throws Exception;
	//根据id删除地址
	public int deleteAddressById(int address_id) throws Exception;
	//修改地址
	public int updateAddress(Address address) throws Exception;
	//根据用户id查询地址
	public List<Address> selectAddressByUser_id(int user_id) throws Exception;
	//查询所有省份
	public List<String> selectAllProvince() throws Exception;
	//根据省份查询城市
	public List<String> selectCityByProvince(String province) throws Exception;
	//根据城市查询区县
	public List<String> selectAreaByCity(String city) throws Exception;
}
