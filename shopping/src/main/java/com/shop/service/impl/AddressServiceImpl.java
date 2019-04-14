package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.mapper.AddressMapper;

import com.shop.service.AddressService;
@Service("addressServiceImpl")
public class AddressServiceImpl implements AddressService{
	@Resource(name="addressMapper")
	private AddressMapper addressMapper;
	@Override
	public List<String> selectAllProvinces() throws Exception {
		return addressMapper.selectAllProvince();
	}

	@Override
	public List<String> selectCityByProvince(String province) throws Exception {
		return addressMapper.selectCityByProvince(province);
	}

	@Override
	public List<String> selectAreaByCity(String city) throws Exception {
		return addressMapper.selectAreaByCity(city);
	}

}
