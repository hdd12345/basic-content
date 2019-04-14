package com.time.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.time.dao.AddressMapper;
import com.time.dao.ChangeLogMapper;
import com.time.entity.Address;
import com.time.entity.ChangeLog;
import com.time.service.ChangeService;

@Service("changeServiceImpl")
public class ChangeServiceImpl implements ChangeService{
	@Resource(name = "changeLogDao")
	private ChangeLogMapper changeLogMapper;
	@Resource(name = "addressDao")
	private AddressMapper addressMapper;
	/**
	 * 添加收货地址
	 */
	@Override
	public int addAddress(Address address) {
		return addressMapper.insertSelective(address);
	}

	/**
	 * 删除地址
	 */
	@Override
	public int deleteAddress(Long arId) {
		return addressMapper.deleteByPrimaryKey(arId);
	}

	/**
	 * 修改地址
	 */
	@Override
	public int updateAddress(Address address) {
		return addressMapper.updateByPrimaryKeySelective(address);
	}

	/**
	 * 显示地址
	 */
	@Override
	public List<Address> showAddress(Long uId) {
		return addressMapper.selectByuId(uId);
	}

	/**
	 * 插入兑换记录
	 */
	@Override
	public int newChangeLog(ChangeLog changeLog) {
		return changeLogMapper.insertSelective(changeLog);
	}

	/**
	 * 显示兑换记录
	 */
	@Override
	public List<ChangeLog> showChangeLog(Long uId) {
		return changeLogMapper.selectByuId(uId);
	}
	
	
}
