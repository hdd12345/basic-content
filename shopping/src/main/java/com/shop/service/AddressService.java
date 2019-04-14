package com.shop.service;

import java.util.List;
/**
 * 此接口仅供省市区三级联动查询所用，不处理收货地址相关业务
 */
public interface AddressService {
	//查询所有省份
	public List<String> selectAllProvinces() throws Exception;
	//根据省份查询城市
	public List<String> selectCityByProvince(String province) throws Exception;
	//根据城市查询区
	public List<String> selectAreaByCity(String city) throws Exception;
}
