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
	 * �����û�id��ѯһ���û����еĵ�ַ
	 */
	@Override
	public List<Address> selectAddress(String userId) throws Exception {
		List<Address> list = addressMapper.selectAddress(userId);
		return list;
	}

	/**
	 * ���ݵ�ַidɾ��һ���ַ
	 */
	@Override
	public int deleteAddess(String addressId) throws Exception {
		return addressMapper.deleteAddess(addressId);
	}

	/**
	 * ����һ���ַ����ַid��uuid����
	 */
	@Override
	public int insertAddess(Address address) throws Exception {
		address.setAddress_id(CommonUtil.getUUID());
		return addressMapper.insertAddess(address);
	}

	/**
	 * ����һ���ַ���ײ��Ǹ���addressId��ʵ�ָ��²���
	 */
	@Override
	public int updateAddress(Address address) throws Exception {

		return addressMapper.updateAddress(address);
	}
	/**
	 * ��ѯ����ʡ��
	 */
	@Override
	public List<String> selectProvince() throws Exception {
		
		return addressMapper.selectProvince();
	}
	/**
	 * ����ʡ�ݲ�ѯ����,���ݳ��в�ѯ����
	 */
	@Override
	public List<String> selectCtiy(String area_parent_id) throws Exception {
		
		return addressMapper.selectCtiy(area_parent_id);
	}

}
