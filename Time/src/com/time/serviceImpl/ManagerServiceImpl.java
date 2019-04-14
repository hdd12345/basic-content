package com.time.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.time.dao.ManagerMapper;

import com.time.entity.Manager;
import com.time.service.ManagerService;

@Service("managerServiceImpl")
public class ManagerServiceImpl implements ManagerService {

	@Resource(name = "managerDao")
	private ManagerMapper managerMapper;

	// ������������manager
	@Override
	public Manager selectByPrimaryKey(Integer managerId) {
		// TODO Auto-generated method stub
		return managerMapper.selectByPrimaryKey(managerId);
	}

	// ���������޸Ĺ���Ա����
	@Override
	public int updateByPrimaryKeySelective(Manager record) {
		// TODO Auto-generated method stub
		return managerMapper.updateByPrimaryKeySelective(record);
	}

	// ����������Ϣ��ѯƥ���manager
	@Override
	public Manager selectSelective(Manager record) {
		// TODO Auto-generated method stub
		return managerMapper.selectSelective(record);
	}

}
