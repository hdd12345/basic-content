package com.cakeshop.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cakeshop.entity.Address;
import com.cakeshop.mapper.AddressMapper;
import com.cakeshop.service.AddressService;
import com.cakeshop.util.CommonUtil;

@Service("addressServiceImpl")
public class AddressServiceImpl implements AddressService {
	@Resource(name = "addressMapper")
	private AddressMapper addressMapper;

	/**
	 * 根据用户id查询一个用户所有的地址
	 */
	@Override
	public List<Address> selectAddress(String userId) throws Exception {
		List<Address> list = addressMapper.selectAddress(userId);
		return list;
	}

	/**
	 * 根据地址id删除一项地址
	 */
	@Override
	public int deleteAddess(String addressId) throws Exception {
		return addressMapper.deleteAddess(addressId);
	}

	/**
	 * 增加一项地址，地址id用uuid生成
	 */
	@Override
	public int insertAddess(Address address) throws Exception {
		address.setAddress_id(CommonUtil.getUUID());
		return addressMapper.insertAddess(address);
	}

	/**
	 * 更新一项地址，底层是根据addressId来实现更新操作
	 */
	@Override
	public int updateAddress(Address address) throws Exception {

		return addressMapper.updateAddress(address);
	}
	/**
	 * 查询所有省份
	 */
	@Override
	public List<String> selectProvince() throws Exception {
		
		return addressMapper.selectProvince();
	}
	/**
	 * 根据省份查询城市,根据城市查询区域
	 */
	@Override
	public List<String> selectCtiy(String area_parent_id) throws Exception {
		
		return addressMapper.selectCtiy(area_parent_id);
	}

}
