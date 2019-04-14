package com.time.service;

import java.util.List;

import com.time.entity.Address;
import com.time.entity.ChangeLog;

public interface ChangeService {
	//添加地址
	public int addAddress(Address address);
	
	//删除地址
	public int deleteAddress(Long arId);
	
	//修改地址
	public int updateAddress(Address address);
	
	//显示所有地址
	public List<Address> showAddress(Long uId);
	
	//插入兑换记录
	public int newChangeLog(ChangeLog changeLog);
	
	//显示兑换记录
	public List<ChangeLog> showChangeLog(Long uId);
}
