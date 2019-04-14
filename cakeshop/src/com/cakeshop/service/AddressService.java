package com.cakeshop.service;

import java.util.List;

import com.cakeshop.entity.Address;

public interface AddressService {
	// ��ѯһ���û��ĵ�ַ
	public List<Address> selectAddress(String userId) throws Exception;

	// ɾ���û���ַ
	public int deleteAddess(String addressId) throws Exception;

	// �����û���ַ
	public int insertAddess(Address address) throws Exception;

	// �޸��û���ַ
	public int updateAddress(Address address) throws Exception;

	// ��ѯ����ʡ��
	public List<String> selectProvince() throws Exception;

	// ��ѯʡ�ݶ�Ӧ������

	public List<String> selectCtiy(String area_parent_id) throws Exception;
}
